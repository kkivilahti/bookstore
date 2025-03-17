package bookstore.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("Atomic Habits");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("James Clear");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Test book", "Test author", "123456789", 2025, 10, null);
        repository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = repository.findByTitle("Into the Wild");
        assertThat(books).hasSize(1);
        repository.delete(books.get(0));

        List<Book> updated = repository.findByTitle("Into the Wild");
        assertThat(updated).isEmpty();
    }
}
