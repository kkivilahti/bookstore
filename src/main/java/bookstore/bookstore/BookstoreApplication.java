package bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
			Book book1 = new Book("How to Win Friends and Influence People", "Dale Carnegie", "9781439199190", 2010, 15.90);
			Book book2 = new Book("The Psychology of Stupidity", "Jean-Francois Marmion", "9781529053869", 2022, 17.90);
			Book book3 = new Book("Atomic Habits", "James Clear", "9781847941831", 2018, 19.90);
			Book book4 = new Book("The Laws of Human Nature", "Robert Greene", "9780143111375", 2019, 18.90);
		
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			repository.save(book4);

			repository.findAll().forEach(System.out::println);
		};
    }

}
