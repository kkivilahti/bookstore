package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository crepository;

    // fetch all categories from the repository and add to model
    // create a view for the list
    @GetMapping("/categorylist")
    public String showCategories(Model model) {
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }

    // create a form page to add new category
    // create an empty category object to store the user input
    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    // save data to the database
    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        crepository.save(category);
        return "redirect:/categorylist";
    }

}
