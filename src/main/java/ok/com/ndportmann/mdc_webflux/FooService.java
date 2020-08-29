package ok.com.ndportmann.mdc_webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.ndportmann.mdc_webflux.helpers.LogHelper.*;

@Service
public class FooService {
    private static final Logger logger
            = LoggerFactory.getLogger(FooService.class);

    public Mono<String> processRequestForClient(String clientId) {
        return Mono.just(clientId)
                .flatMap(id -> processRequest(id))
                .doOnEach(logOnNext(
                        res -> logger.info("Result: {}", res))
                ).doOnEach(logOnError(
                        e -> logger.warn("An error occurred...", e))
                ).subscriberContext(put("CLIENT-ID", clientId));
    }

    private Mono<String> processRequest(String id) {
        return Mono.just("42");
    }
}
