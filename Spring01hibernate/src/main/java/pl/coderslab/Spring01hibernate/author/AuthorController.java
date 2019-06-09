package pl.coderslab.Spring01hibernate.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Spring01hibernate.commons.ViewMode;
import pl.coderslab.Spring01hibernate.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @ModelAttribute("allAuthors")
    public List<Author> findAllAuthors(@ModelAttribute AuthorViewMode viewMode) {
        if("all".equals(viewMode.getSearchMode())) {
            return authorRepository.findAll();
        }
        if("email".equals(viewMode.getSearchMode())) {
            return authorRepository.findByEmail(viewMode.getEmailSearch());
        }
        if("pesel".equals(viewMode.getSearchMode())) {
            return authorRepository.findByPesel(viewMode.getPeselSearch());
        }
        if("lastName".equals(viewMode.getSearchMode())) {
            return authorRepository.findByLastName(viewMode.getLastNameSearch());
        }
        return new ArrayList<>();
    }

    @GetMapping("/add")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author/addAndEdit";
    }

    @PostMapping("/add")
    public String addAuthorPost(@ModelAttribute @Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "author/addAndEdit";
        }
        authorRepository.save(author);
        return "redirect:/author/all";
    }

    @GetMapping("/all")
    public String viewAll(ModelMap model) {
        model.addAttribute("viewMode", model.getOrDefault("viewMode", new AuthorViewMode()));
        return "author/all";
    }

    @PostMapping("/all")
    public ModelAndView postAction(@ModelAttribute AuthorViewMode viewMode, ModelMap modelMap) {
        modelMap.addAttribute("authorId", viewMode.getObjectId());
        if("edit".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/author/edit", modelMap);
        }
        if("remove".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/author/remove", modelMap);
        }
        return new ModelAndView("/author/all");
    }

    @GetMapping("/remove")
    public String removeAuthor(@ModelAttribute("authorId") long id, Model model) {
        model.addAttribute("author", authorRepository.findById(id).get());
        return "author/remove";
    }

    @PostMapping("/remove")
    public String removeAuthorPost(@ModelAttribute Author author) {
        authorRepository.delete(author);
        return "redirect:/author/all";
    }

    @GetMapping("/edit")
    public String editAuthor(@ModelAttribute("authorId") long id, Model model) {
        model.addAttribute("author", authorRepository.findById(id).get());
        return "author/addAndEdit";
    }

    @PostMapping("/edit")
    public String editAuthorPost(@ModelAttribute @Valid Author author, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "author/addAndEdit";
        }
        authorRepository.save(author);
        return "redirect:/author/all";
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

   /* @RequestMapping("/add")
    @ResponseBody
    public Author persist(){
        Author author = new Author();
        author.setFirstName("Firstname");
        author.setLastName("LastName");
        authorDao.persist(author);
        return author;
    }

    @RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
    public String redirect(Model model) {
        model.addAttribute("author", new Author());
        return "newAuthor";
    }

    @RequestMapping(value = "/newAuthor", method = RequestMethod.POST)
    public String addNewAuthor(@ModelAttribute @Valid Author newAuthor, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "newAuthor";
        }
        authorDao.persist(newAuthor);
        return "viewAuthor";
    }*/

}
