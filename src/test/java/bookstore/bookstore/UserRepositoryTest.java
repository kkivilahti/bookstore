package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.bookstore.domain.User;
import bookstore.bookstore.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnRole() {
        User userByUsername = repository.findByUsername("user");

        assertThat(userByUsername).isNotNull();
        assertThat(userByUsername.getRole()).isEqualTo("USER");
    }

    @Test
    public void createNewUser() {
        User user = new User("testuser", "0000", "USER");
        repository.save(user);

        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteUserById() {
        User user = new User("testuser", "0000", "USER");
        repository.save(user);

        repository.deleteById(user.getId());
        User userByUsername = repository.findByUsername("testuser");
        assertThat(userByUsername).isNull();
    }
}
