package de.tu_darmstadt.tk.wardriving.boundary;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("/processed")
    public String processed(ModelAndView model) {
        return "processed";
    }

}
