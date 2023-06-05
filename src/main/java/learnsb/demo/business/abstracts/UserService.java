package learnsb.demo.business.abstracts;

import learnsb.demo.core.entities.User;
import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.entities.concretes.Product;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
