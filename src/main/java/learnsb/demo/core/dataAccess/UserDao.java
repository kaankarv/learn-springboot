package learnsb.demo.core.dataAccess;

import learnsb.demo.core.entities.User;
import learnsb.demo.core.utilities.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
