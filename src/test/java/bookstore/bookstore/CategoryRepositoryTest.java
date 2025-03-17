package bookstore.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("psychology");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("psychology");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("test");
        repository.save(category);

        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        List<Category> categories = repository.findByName("history");
        assertThat(categories).hasSize(1);
        repository.delete(categories.get(0));

        List<Category> updated = repository.findByName("history");
        assertThat(updated).isEmpty();
    }
}
