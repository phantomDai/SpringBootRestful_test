package test;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreatingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();//实现快速和高并发
	
	@RequestMapping("/greeting")
	public Greeting greating(@RequestParam(value="name",defaultValue="world")String name){
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
}
