package bookstore.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    // fetch all books from the repository and add to model
    // create a view for the list
    @GetMapping("/booklist")
    public String showBooklist(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }

    // create a form page to add a new book
    // create an empty book object to store the user input
    // fetch categories from the database (for the dropdown)
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    // save the information to the database
    @PostMapping("/save")
    public String save(Book book) {
        brepository.save(book);
        return "redirect:/booklist";
    }

    // delete a book from the database based on id
    // only admin user is authorized to delete a book
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        brepository.deleteById(id);
        return "redirect:/booklist";
    }

    // fetch book data by id
    // pass the data to the model
    // create a form page to edit the book
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = brepository.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
}
