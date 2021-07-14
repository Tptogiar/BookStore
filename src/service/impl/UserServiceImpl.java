package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/08-18:29
 */


public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean existsEmail(String email){
        if(userDao.queryUserByEmail(email)==null){
            return false;
        }
        return true;
    }
}
