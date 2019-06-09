package pl.coderslab.Spring01hibernate.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.Spring01hibernate.repository.AuthorRepository;


@Component
public class AuthorConverter implements Converter<String, Author> {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorConverter(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author convert(String s) {
        return authorRepository.findById(Long.valueOf(s)).get();
    }
}
