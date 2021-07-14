package dao;

import pojo.User;

public interface UserDao {



    User queryUserByUsername(String username);

    User queryUserByEmail(String email);

    User queryUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);

}
