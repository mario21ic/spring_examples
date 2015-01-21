package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/info")
    public Map<String, String> info(@RequestParam(value="name", defaultValue="World") String name) {
    	HashMap<String, String> parametros = new HashMap<String, String>();
    	Map<String, String> env = System.getenv();
    	for (String envName : env.keySet()) {
        	parametros.put(envName, env.get(envName));
        }
    	return parametros;
        // return System.getenv();
    }

    /*
    @RequestMapping("/u/{tunombre}/")
    public void readTable(@PathVariable String tunombre,
            HttpServletRequest request,
            HttpServletResponse response){
        PrintWriter writer = response.getWriter();
        writer.print("Hola Mundo<br/>");
        writer.print("Como estas "+tunombre);
    }
    */
}
