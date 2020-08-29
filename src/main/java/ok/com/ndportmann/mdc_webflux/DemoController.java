package ok.com.ndportmann.mdc_webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.ndportmann.mdc_webflux.helpers.MdcHeaderFilter.CONTEXT_MAP;

@RestController
public class DemoController {
    private static final Collector<CharSequence, ?, String> COLLECTOR
            = Collectors.joining("," + System.lineSeparator(), "[", "]");

    private final FooService fooService;

    public DemoController(FooService fooService) {
        this.fooService = fooService;
    }

    private static Mono<String> apply(String prefix) {
        return Mono.subscriberContext()
                .map(x -> x.<Map<String, String>>get(CONTEXT_MAP))
                .map(x -> prefix + x.entrySet().stream()
                        .map(kv -> kv.getKey() + ": " + kv.getValue())
                        .collect(COLLECTOR));
    }

    @GetMapping("/demo")
    public Mono<String> demo() {
        return Mono.just("The context contains: " + System.lineSeparator())
                .flatMap(DemoController::apply);
    }

    @PostMapping("/demo/{clientId}")
    public Mono<String> clientDemo(@PathVariable String clientId) {
        return fooService.processRequestForClient(clientId);
    }
}
