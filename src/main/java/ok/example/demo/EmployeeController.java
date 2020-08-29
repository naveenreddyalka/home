package ok.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/{id}")
	private Mono<Employee> getEmployeeById(@PathVariable Integer id) {
	    return Mono.just(employeeRepository.findById(id).orElse(null));
	}
	
	@GetMapping
	private Flux<Employee> getAllEmployees() {
	    return Flux.fromIterable(employeeRepository.findAll());
	}
}
