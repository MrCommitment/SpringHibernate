package pl.coderslab.Spring01hibernate.book;

import pl.coderslab.Spring01hibernate.Category;
import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.publisher.Publisher;
import pl.coderslab.Spring01hibernate.validation.BookValidationGroup;
import pl.coderslab.Spring01hibernate.validation.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 5, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String title;

    @Min(value = 1, groups = BookValidationGroup.class)
    private int pages;

    @NotEmpty(groups = BookValidationGroup.class)
    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    @Min(value = 1, groups = BookValidationGroup.class)
    @Max(value = 10, groups = BookValidationGroup.class)
    private int rating;

    @NotNull(groups = BookValidationGroup.class)
    @ManyToOne
    private Publisher publisher;

    @NotEmpty(groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    @Size(max = 50, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String description;

    private boolean proposition;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
