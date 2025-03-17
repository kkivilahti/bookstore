package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.bookstore.domain.UserRepository;
import bookstore.bookstore.web.BookController;
import bookstore.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(userRepository).isNotNull();
	}
}
