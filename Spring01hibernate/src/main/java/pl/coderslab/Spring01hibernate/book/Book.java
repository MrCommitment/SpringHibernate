package pl.coderslab.Spring01hibernate.book;

import pl.coderslab.Spring01hibernate.author.Author;
import pl.coderslab.Spring01hibernate.publisher.Publisher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    private int rating;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Publisher publisher;

    private String description;

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
