package com.ndportmann.mdc_webflux.helpers;

import org.slf4j.MDC;
import reactor.core.publisher.Signal;
import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.ndportmann.mdc_webflux.helpers.MdcHeaderFilter.CONTEXT_MAP;

public class LogHelper {

    public static <T> Consumer<Signal<T>> logOnNext(
            Consumer<T> log) {
        return signal -> {
            if (signal.getType() != SignalType.ON_NEXT) return;

            Optional<Map<String, String>> maybeContextMap
                    = signal.getContext().getOrEmpty(CONTEXT_MAP);

            if (maybeContextMap.isPresent()) {
                log.accept(signal.get());
            } else {
                MDC.setContextMap(maybeContextMap.get());
                try {
                    log.accept(signal.get());
                } finally {
                    MDC.clear();
                }
            }
        };
    }

    public static <T> Consumer<Signal<T>> logOnError(
            Consumer<Throwable> log) {
        return signal -> {
            if (!signal.isOnError()) return;

            Optional<Map<String, String>> maybeContextMap
                    = signal.getContext().getOrEmpty(CONTEXT_MAP);

            if (maybeContextMap.isPresent()) {
                log.accept(signal.getThrowable());
            } else {
                MDC.setContextMap(maybeContextMap.get());
                try {
                    log.accept(signal.getThrowable());
                } finally {
                    MDC.clear();
                }
            }
        };
    }

    public static Function<Context, Context> put(String key, String value) {
        return ctx -> {
            Optional<Map<String, String>> maybeContextMap =
                    ctx.getOrEmpty(CONTEXT_MAP);

            if (maybeContextMap.isPresent()) {
                maybeContextMap.get().put(key, value);
                return ctx;
            } else {
                Map<String, String> ctxMap = new HashMap<>();
                ctxMap.put(key, value);

                return ctx.put(CONTEXT_MAP, ctxMap);
            }
        };
    }
}
