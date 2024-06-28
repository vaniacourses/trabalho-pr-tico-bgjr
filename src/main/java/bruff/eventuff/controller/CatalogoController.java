package bruff.eventuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogoController {

    @RequestMapping("/") //teste que nao funcionou?
    public String index (Model model){
        model.addAttribute("titulo_pag","EventUFF");
        return "homePage";
    }
}
