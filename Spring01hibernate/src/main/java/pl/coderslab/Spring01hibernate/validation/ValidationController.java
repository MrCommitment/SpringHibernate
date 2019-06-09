package pl.coderslab.Spring01hibernate.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.book.Book;
import pl.coderslab.Spring01hibernate.commons.Error;
import pl.coderslab.Spring01hibernate.commons.HomeContext;
import pl.coderslab.Spring01hibernate.publisher.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/validator")
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("homeContext", new HomeContext());
        return "validator/home";
    }

    @PostMapping("/home")
    public String redirect(@ModelAttribute HomeContext homeContext) {
        if("book".equals(homeContext.getRedirectPage())) {
            return "redirect:/validator/validateBook";
        }
        if("author".equals(homeContext.getRedirectPage())) {
            return "redirect:/validator/validateAuthor";
        }
        if("publisher".equals(homeContext.getRedirectPage())) {
            return "redirect:/validator/validatePublisher";
        }
        return "validator/home";
    }

    @GetMapping(value = "/validateBook")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setTitle("rtrr");
        Set<ConstraintViolation<Book>> validations = validator.validate(book);
        model.addAttribute("errors", validations.stream()
                .map(Error::new)
                .collect(Collectors.toList()));
        return "validator/show";
    }

    @GetMapping(value = "/validateAuthor")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setPesel("12312312322");
        author.setEmail("asdokaosdasokdoasdoa");
        Set<ConstraintViolation<Author>> validations = validator.validate(author);
        model.addAttribute("errors", validations.stream()
                .map(Error::new)
                .collect(Collectors.toList()));
        return "validator/show";
    }

    @GetMapping(value = "/validatePublisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setRegon("123123123");
        publisher.setNip("123123123");
        Set<ConstraintViolation<Publisher>> validations = validator.validate(publisher);
        model.addAttribute("errors", validations.stream()
                .map(Error::new)
                .collect(Collectors.toList()));
        return "validator/show";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/validator/home";
    }

    @GetMapping("/backHome")
    public String goHome() {
        return "redirect:/";
    }

}
