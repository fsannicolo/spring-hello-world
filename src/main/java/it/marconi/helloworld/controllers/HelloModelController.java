package it.marconi.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("other")
public class HelloModelController {
    
    // passa un parametro fisso tramite dizionario del Model
    @GetMapping("fixed")
    public ModelAndView greetAttribute() {

        return new ModelAndView("hello-world-model").addObject("name", "Marconi");
    }

    // passa un parametro tramite query string
    @GetMapping("query")
    public ModelAndView greetParameter(@RequestParam(defaultValue = "none") String name) {
        // se non specifico il nome del parametro query, viene generato dal nome del parametro formale
        return new ModelAndView("hello-world-model").addObject("name", name);
    }

    // passa un parametro recuperato dal path URL
    @GetMapping("path/{username}")
    public ModelAndView greetPlaceholder(@PathVariable String username) {
        // se non specifico il nome della path variable, viene generata dal nome del parametro formale
        return new ModelAndView("hello-world-username").addObject("username", username);
    }

    // --- per le seguenti serve un client HTTP come Postman o REST client, non è possibile testarle da browser ---

    // rileva un header nella richiesta
    @GetMapping(path = "header", headers = "myHeader")
    public ModelAndView greetHeader(@RequestHeader(defaultValue = "none") String myHeader) {
        
        return new ModelAndView("hello-world-header").addObject("header", myHeader);
    }

    // rileva un body nella richiesta (deve essere una POST, body non ammessi nelle GET)
    @PostMapping("body")
    public ModelAndView greetBody(@RequestBody String body) {
        
        return new ModelAndView("hello-world-body").addObject("body", body);
    }

}
