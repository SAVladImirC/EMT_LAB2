package Services.Impl;

import Models.Book;
import Repository.BookRepository;
import Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(Book book) {
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        Book temp = this.bookRepository.getById(id);
        temp.setAuthor(book.getAuthor());
        temp.setAvailableCopies(book.getAvailableCopies());
        temp.setName(book.getName());
        temp.setCategory(book.getCategory());
        this.bookRepository.save(temp);
        return Optional.of(temp);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
