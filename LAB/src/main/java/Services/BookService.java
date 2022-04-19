package Services;

import Models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(Book book);
    Optional<Book> edit(Long id, Book book);
    void deleteById(Long id);
}
