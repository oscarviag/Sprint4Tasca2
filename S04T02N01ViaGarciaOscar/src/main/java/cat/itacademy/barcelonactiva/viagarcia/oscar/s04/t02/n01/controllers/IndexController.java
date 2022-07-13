package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n01.controllers;



import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController implements ErrorController{
	
    private final static String PATH = "/error";
    
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        
        return "Operació no trobada";
    }
	
	

}
