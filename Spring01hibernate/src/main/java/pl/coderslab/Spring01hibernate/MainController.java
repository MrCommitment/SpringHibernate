package pl.coderslab.Spring01hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Spring01hibernate.commons.HomeContext;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("homeContext", new HomeContext());
        return "home";
    }

    @PostMapping("/")
    public String postMapping(@ModelAttribute HomeContext homeContext) {
        if("person".equals(homeContext.getRedirectPage())) {
            return "redirect:/person/all";
        }
        if("student".equals(homeContext.getRedirectPage())) {
            return "redirect:/student/add";
        }
        if("publisher".equals(homeContext.getRedirectPage())) {
            return "redirect:/publisher/all";
        }
        if("author".equals(homeContext.getRedirectPage())) {
            return "redirect:/author/all";
        }
        if("validator".equals(homeContext.getRedirectPage())) {
            return "redirect:/validator/home";
        }
        if("book".equals(homeContext.getRedirectPage())) {
            return "redirect:/book/all";
        }
        if("proposition".equals(homeContext.getRedirectPage())) {
            return "redirect:/proposition/all";
        }
        return "/";
    }

}
