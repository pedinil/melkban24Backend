package ir.melkban24;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mehdi on 3/12/17.
 */
@Controller
public class WelcomeController {

    @Value("${welcome.message:test}")
    private String message = "Hello";

    @RequestMapping("/")
    public String welcome(Map<String,Object> model) {
        model.put("message",this.message);
        return "welcome";
    }
}
