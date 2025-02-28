package bookstore.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
    
    @Autowired
    private BookRepository repository;

    // returns all books as json
    @GetMapping("/books")
    public @ResponseBody List<Book> allBooksRest() {
        return (List<Book>)repository.findAll();
    }

    // returns one book (based on its id) as json
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> bookByIdRest(@PathVariable(name = "id") Long id) {
        return repository.findById(id);
    }

    // enables adding a new book via rest api
    @PostMapping("/books")
    public @ResponseBody Book addBookRest(@RequestBody Book newBook) {
        return repository.save(newBook);
    }
}
