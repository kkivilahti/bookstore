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

import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@RestController
public class CategoryRestController {
    
    @Autowired
    private CategoryRepository repository;

    // returns all categories as json
    @GetMapping("/categories")
    public @ResponseBody List<Category> allCategoriesRest() {
        return (List<Category>)repository.findAll();
    }

    // returns one category (based on its id) as json
    @GetMapping("/categories/{id}")
    public @ResponseBody Optional<Category> categoryByIdRest(@PathVariable(name = "id") Long id) {
        return repository.findById(id);
    }

    // enables adding a new category via rest api
    @PostMapping("/categories")
    public @ResponseBody Category addCategoryRest(@RequestBody Category newCategory) {
        return repository.save(newCategory);
    }
}
