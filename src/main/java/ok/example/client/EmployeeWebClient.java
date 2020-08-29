package ok.example.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;

public class EmployeeWebClient {

	private static <T> T identityWithThreadLogging(T el, String operation) {
		System.out.println(operation + " -- " + el + " -- " + Thread.currentThread().getName());
		return el;
	}

	public static void main(String[] args) {
		List<Context> lcoalc = new ArrayList<>();

		Mono.just("one").map(s -> {
			Flux.range(1, 3).subscriberContext(Mono.subscriberContext().block());
			return s;
		}).flatMap(t -> Mono.just(t)).doOnEach(s -> {
			lcoalc.add(s.getContext());
		});

		Flux.range(1, 3).map(n -> identityWithThreadLogging(n, "map1")).flatMap(
				n -> Mono.just(n).map(nn -> identityWithThreadLogging(nn, "mono")).subscribeOn(Schedulers.parallel()))
				.subscriberContext(con -> {
					con.putAll(Mono.subscriberContext().block());
					return con;
				}).subscribe(n -> {
					identityWithThreadLogging(n, "subscribe");
					System.out.println(n);
				});

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Flux<Integer> ints = Flux.range(1, 4) .map(i -> { if (i <= 3) return i; throw
		 * new RuntimeException("Got to 4"); });
		 * 
		 * ints.subscribe(i -> System.out.println(i), error ->
		 * System.err.println("Error: " + error));
		 * 
		 * 
		 * Flux<String> bridge = Flux.create(sink -> { sink.next("one");
		 * sink.complete(); //sink. });
		 * 
		 * 
		 * 
		 * Mono.just("tetsing").flatMap(s -> { Mono.subscriberContext().map( m -> {
		 * m.put(2, 2); return m; }).subscribe(c -> { System.out.println("1-> "
		 * +c.get("1") + " = "+ c.toString()); }); return Mono.just(s);
		 * }).subscriberContext( con -> { con.put("1", 1); return con; }).subscribe(c ->
		 * { Mono.subscriberContext().subscribe(b -> { System.out.println("1-> " +
		 * b.toString()); }); System.out.println("2-> " + c.toString()); });
		 * 
		 * 
		 * WebClient client = WebClient.create("http://localhost:8080"); Mono<Employee>
		 * employeeMono = client.get().uri("/employees/{id}",
		 * "1").retrieve().bodyToMono(Employee.class);
		 * 
		 * employeeMono.subscribe(System.out::println);
		 * 
		 * Flux<Employee> employeeFlux =
		 * client.get().uri("/employees").retrieve().bodyToFlux(Employee.class);
		 * 
		 * employeeFlux.subscribe(System.out::println);
		 * 
		 * try { Thread.sleep(100000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
