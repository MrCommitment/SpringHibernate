package pl.coderslab.Spring01hibernate.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Spring01hibernate.commons.ViewMode;
import pl.coderslab.Spring01hibernate.repository.PublisherRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @ModelAttribute("allPublishers")
    public List<Publisher> findAll(@ModelAttribute PublisherViewMode viewMode) {
        if("all".equals(viewMode.getSearchMode())) {
            return publisherRepository.findAll();
        }
        if("nip".equals(viewMode.getSearchMode())) {
            return publisherRepository.findByNip(viewMode.getNipSearch());
        }
        if("regon".equals(viewMode.getSearchMode())) {
            return publisherRepository.findByRegon(viewMode.getRegonSearch());
        }
        return new ArrayList<>();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/addAndEdit";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute @Valid Publisher publisher, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/publisher/addAndEdit";
        }
        publisherRepository.save(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/all")
    public String viewAll(ModelMap model) {
        model.addAttribute("viewMode", model.getOrDefault("viewMode", new PublisherViewMode()));
        return "publisher/all";
    }

    @PostMapping("/all")
    public ModelAndView postAction(@ModelAttribute PublisherViewMode viewMode, ModelMap modelMap) {
        modelMap.addAttribute("publisherId", viewMode.getObjectId());
        if("edit".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/publisher/edit", modelMap);
        }
        if("remove".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/publisher/remove", modelMap);
        }
        return new ModelAndView("/person/all");
    }

    @GetMapping("/remove")
    public String removePublisher(@ModelAttribute("publisherId") long id, Model model) {
        model.addAttribute("publisher", publisherRepository.findById(id).get());
        return "publisher/remove";
    }

    @PostMapping("/remove")
    public String removePublisherPost(@ModelAttribute Publisher publisher) {
        publisherRepository.delete(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/edit")
    public String editPublisher(@ModelAttribute("publisherId") long id, Model model) {
        model.addAttribute("publisher", publisherRepository.findById(id).get());
        return "publisher/addAndEdit";
    }

    @PostMapping("/edit")
    public String editPublisherPost(@ModelAttribute @Valid Publisher publisher, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "publisher/addAndEdit";
        }
        publisherRepository.save(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/home")
    public String goHome() {
        return "redirect:/";
    }




    /**
     *
     * STARA IMPLEMENTACJA
     *
     * */

    /*@RequestMapping("/find/{id}")
    @ResponseBody
    public Publisher merge(@PathVariable("id")long id) {
        return publisherDao.findById(id);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAllPublishers() {
        return publisherDao.findAll().toString();
    }

    @RequestMapping("/changeName/{id}/{name}")
    @ResponseBody
    public String changeDescription(@PathVariable("name") String name, @PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.merge(publisher);
        return "Żądanie zakończone sukcesem";
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.remove(publisher);
        return "Żądanie zakończone sukcesem";
    }*/

}
