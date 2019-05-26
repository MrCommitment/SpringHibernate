package pl.coderslab.Spring01hibernate.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping("/add")
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
    public String addNewAuthor(@ModelAttribute Author newAuthor, Model model) {
        authorDao.persist(newAuthor);
        return "viewAuthor";
    }

}
