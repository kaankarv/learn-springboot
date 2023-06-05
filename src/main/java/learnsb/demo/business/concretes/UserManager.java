package learnsb.demo.business.concretes;

import learnsb.demo.business.abstracts.UserService;
import learnsb.demo.core.dataAccess.UserDao;
import learnsb.demo.core.entities.User;
import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.core.utilities.results.SuccesDataResult;
import learnsb.demo.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }


    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanici eklendi.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccesDataResult<User>(this.userDao.findByEmail(email), "Kullanici bulundu.");
    }
}
