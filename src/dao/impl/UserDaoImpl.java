package dao.impl;

import dao.UserDao;
import pojo.User;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/08-18:07
 */


public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql="select `username` from t_user where username= ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByEmail(String email){
        String sql="select `email` from t_user where email=?";
        return queryForOne(User.class,sql,email);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username= ? and password= ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user (`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
