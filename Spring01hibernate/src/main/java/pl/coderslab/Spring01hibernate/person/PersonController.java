package pl.coderslab.Spring01hibernate.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Spring01hibernate.commons.ViewMode;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @ModelAttribute("allPersons")
    public List<Person> findAllPersons() {
        return personDao.findAll();
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person/addAndEdit";
    }

    @PostMapping("/add")
    public String savePerson(@ModelAttribute Person person) {
        personDao.persist(person);
        return "redirect:/person/all";
    }

    @GetMapping("/all")
    public String viewAll(Model model) {
        model.addAttribute("viewMode", new ViewMode());
        return "person/all";
    }

    @PostMapping("/all")
    public ModelAndView postAction(@ModelAttribute ViewMode viewMode, ModelMap model) {
        model.addAttribute("personId", viewMode.getObjectId());
        if("edit".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/person/edit", model);
        }
        if("remove".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/person/remove", model);
        }
        return new ModelAndView("/person/all");
    }

    @GetMapping("/remove")
    public String removePerson(@ModelAttribute("personId") long id, Model model) {
        model.addAttribute("person", personDao.findById(id));
        return "person/remove";
    }

    @PostMapping("/remove")
    public String removePersonPost(@ModelAttribute Person person) {
        personDao.remove(person);
        return "redirect:/person/all";
    }

    @GetMapping("/edit")
    public String editPerson(@ModelAttribute("personId")long id, Model model) {
        model.addAttribute("person", personDao.findById(id));
        return "person/addAndEdit";
    }

    @PostMapping("/edit")
    public String editPersonPost(@ModelAttribute Person person) {
        personDao.merge(person);
        return "redirect:/person/all";
    }

    @GetMapping("/home")
    public String goHome() {
        return "redirect:/";
    }

}
