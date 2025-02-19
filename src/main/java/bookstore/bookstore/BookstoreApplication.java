package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	// new logger attribute
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
        return (args) -> {
			// add demo data to repositories

			Book book1 = new Book("Atomic Habits", "James Clear", "9781847941831", 2018, 19.90);
			Book book2 = new Book("Thinking, Fast and Slow", "Daniel Kahneman", "9780374533557", 2013, 18.90);
			Book book3 = new Book("The Psychology of Stupidity", "Jean-Francois Marmion", "9781529053869", 2022, 17.90);
			Book book4 = new Book("Short History of Nearly Everything", "Bill Bryson", "9780552151740", 2004, 15.90);
			Book book5 = new Book("Genghis Khan and the Making of the Modern World", "Jack Weatherford", "9780609809648", 2005, 22.90);
			Book book6 = new Book("The Diary of a Young Girl", "Anne Frank", "9780553296983", 1993, 20.90);
			Book book7 = new Book("Into the Wild", "Jon Krakauer", "9780385486804", 1997, 18.90);
			Book book8 = new Book("Educated", "Tara Westover", "9780099511021", 2018, 17.90);

			brepository.save(book1);
			brepository.save(book2);
			brepository.save(book3);
			brepository.save(book4);
			brepository.save(book5);
			brepository.save(book6);
			brepository.save(book7);
			brepository.save(book8);

			// show data in terminal
			for (Book b : brepository.findAll()) {
				log.info(b.toString());
			}

			Category c1 = new Category("psychology");
			Category c2 = new Category("history");
			Category c3 = new Category("biography");

			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);

			for (Category c : crepository.findAll()) {
				log.info(c.toString());
			}
		};
    }

}
