package pl.coderslab.Spring01hibernate.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.Spring01hibernate.Category;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.commons.ViewMode;
import pl.coderslab.Spring01hibernate.publisher.Publisher;
import pl.coderslab.Spring01hibernate.repository.AuthorRepository;
import pl.coderslab.Spring01hibernate.repository.BookRepository;
import pl.coderslab.Spring01hibernate.repository.CategoryRepository;
import pl.coderslab.Spring01hibernate.repository.PublisherRepository;
import pl.coderslab.Spring01hibernate.validation.BookValidationGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;


    @ModelAttribute("publishers")
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    @ModelAttribute("allBooks")
    public List<Book> allBooks(@ModelAttribute BookViewMode viewMode) {
        if("all".equals(viewMode.getSearchMode())) {
            return bookRepository.findBooksByPropositionIsFalse();
        }
        if("category".equals(viewMode.getSearchMode())) {
            return bookRepository.findBooksByCategoryAndProposition(viewMode.getCategorySearch(), false);
        }
        if("title".equals(viewMode.getSearchMode())) {
            return bookRepository.findTitle(viewMode.getTitleSearch(), false);
        }
        if("publisher".equals(viewMode.getSearchMode())) {
            return bookRepository.findBooksByPublisherAndProposition(viewMode.getPublisherSearch(), false);
        }
        return new ArrayList<>();
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/addAndEdit";
    }

    @PostMapping("/add")
    public String saveBook(@ModelAttribute @Validated(BookValidationGroup.class) Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book/addAndEdit";
        }
        book.getAuthors().forEach(a -> a.getBooks().add(book));
        bookRepository.save(book);
        return "redirect:/book/all";
    }

    @GetMapping("/all")
    public String redirect(ModelMap model) {
        model.addAttribute("viewMode", model.getOrDefault("viewMode", new BookViewMode()));
        return "book/all";
    }

    @PostMapping("/all")
    public ModelAndView postAction(@ModelAttribute BookViewMode viewMode, ModelMap modelMap){
        if("edit".equals(viewMode.getMode())) {
            modelMap.addAttribute("bookId", viewMode.getObjectId());
            return new ModelAndView("redirect:/book/edit", modelMap);
        }
        if("remove".equals(viewMode.getMode())) {
            modelMap.addAttribute("bookId", viewMode.getObjectId());
            return new ModelAndView("redirect:/book/remove", modelMap);
        }
        if("resetRating".equals(viewMode.getMode())) {
            bookRepository.resetRating(viewMode.getResetRating());
            return new ModelAndView("redirect:/book/all");
        }
        return new ModelAndView("/book/all");
    }

    @GetMapping("/remove")
    public String removeBook(@ModelAttribute("bookId") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "book/remove";
    }

    @PostMapping("/remove")
    public String removeBook(@ModelAttribute Book book) {
        Book b = bookRepository.findById(book.getId()).get();
        b.getAuthors().forEach(a -> a.getBooks().remove(b));
        bookRepository.delete(book);
        return "redirect:/book/all";
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
    public String editAuthor(@ModelAttribute @Validated(BookValidationGroup.class) Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "book/addAndEdit";
        }
        book.getAuthors().forEach(a -> a.getBooks().add(book));
        bookRepository.save(book);
        return "redirect:/book/all";
    }

    @GetMapping("/home")
    public String goHome() {
        return "redirect:/";
    }

}
