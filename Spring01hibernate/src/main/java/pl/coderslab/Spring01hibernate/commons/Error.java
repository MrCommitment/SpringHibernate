package pl.coderslab.Spring01hibernate.commons;

import pl.coderslab.Spring01hibernate.book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Path;

public class Error<T> {

    private Path field;
    private String message;

    public Error() {
    }

    public Error(ConstraintViolation<T> errorField) {
        this.field = errorField.getPropertyPath();
        this.message = errorField.getMessage();
    }

    public Path getField() {
        return field;
    }

    public void setField(Path field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
