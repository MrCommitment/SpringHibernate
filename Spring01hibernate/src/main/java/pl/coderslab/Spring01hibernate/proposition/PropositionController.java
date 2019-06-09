package pl.coderslab.Spring01hibernate.proposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Spring01hibernate.Category;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.book.Book;
import pl.coderslab.Spring01hibernate.book.BookViewMode;
import pl.coderslab.Spring01hibernate.commons.ViewMode;
import pl.coderslab.Spring01hibernate.publisher.Publisher;
import pl.coderslab.Spring01hibernate.repository.AuthorRepository;
import pl.coderslab.Spring01hibernate.repository.BookRepository;
import pl.coderslab.Spring01hibernate.repository.CategoryRepository;
import pl.coderslab.Spring01hibernate.repository.PublisherRepository;
import pl.coderslab.Spring01hibernate.validation.PropositionValidationGroup;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @ModelAttribute("publishers")
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    @ModelAttribute("allBooks")
    public List<Book> allBooks(@ModelAttribute BookViewMode viewMode) {
        if("all".equals(viewMode.getSearchMode())) {
            return bookRepository.findBooksByPropositionIsTrue();
        }
        if("category".equals(viewMode.getSearchMode())) {
            return bookRepository.findBooksByCategoryAndProposition(viewMode.getCategorySearch(), true);
        }
        if("title".equals(viewMode.getSearchMode())) {
            return bookRepository.findBookByTitleAndProposition(viewMode.getTitleSearch(), true);
        }
        if("publisher".equals(viewMode.getSearchMode())) {
            return bookRepository.findBooksByPublisherAndProposition(viewMode.getPublisherSearch(), true);
        }
        return new ArrayList<>();
    }

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/add")
    public String addProposition(Model model) {
        model.addAttribute("book", new Book());
        return "book/addAndEdit";
    }

    @PostMapping("/add")
    public String addProposition(@ModelAttribute @Validated(PropositionValidationGroup.class) Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book/addAndEdit";
        }
        book.setProposition(true);
        book.getAuthors().forEach(a -> a.getBooks().add(book));
        bookRepository.save(book);
        return "redirect:/proposition/all";
    }

    @GetMapping("/all")
    public String redirect(ModelMap model) {
        model.addAttribute("viewMode", model.getOrDefault("viewMode", new BookViewMode()));
        return "book/all";
    }

    @PostMapping("/all")
    public ModelAndView postAction(@ModelAttribute BookViewMode viewMode, ModelMap modelMap){
        modelMap.addAttribute("bookId", viewMode.getObjectId());
        if("edit".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/proposition/edit", modelMap);
        }
        if("remove".equals(viewMode.getMode())) {
            return new ModelAndView("redirect:/proposition/remove", modelMap);
        }
        return new ModelAndView("/book/all");
    }

    @GetMapping("/remove")
    public String removeBook(@ModelAttribute("bookId") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "book/remove";
    }

    @PostMapping("/remove")
    public String removeBook(@ModelAttribute Book book) {
        Book b = bookRepository.findById(book.getId()).get();
        b.getAuthors().forEach(a -> a.getBooks().remove(b));
        bookRepository.delete(book);
        return "redirect:/proposition/all";
    }

    @GetMapping("/edit")
    public String editBook(@ModelAttribute("bookId") long id, Model model) {
        Book b = bookRepository.findById(id).get();
        b.getAuthors().forEach(a -> {
            a.getBooks().remove(b);
            authorRepository.save(a);
        });
        model.addAttribute("book", b);
        return "book/addAndEdit";
    }

    @PostMapping("/edit")
    public String editAuthor(@ModelAttribute @Validated(PropositionValidationGroup.class) Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "book/addAndEdit";
        }
        book.setProposition(true);
        book.getAuthors().forEach(a -> a.getBooks().add(book));
        bookRepository.save(book);
        return "redirect:/proposition/all";
    }

    @GetMapping("/home")
    public String goHome() {
        return "redirect:/";
    }

}
