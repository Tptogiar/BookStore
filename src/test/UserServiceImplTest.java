package test;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    UserService userService=new UserServiceImpl();


    @org.junit.jupiter.api.Test
    void registUser() {

        userService.registUser(new User(null,"test1","test1","test1"));

    }

    @org.junit.jupiter.api.Test
    void login() {
        System.out.println(userService.login(new User(null, "test1", "test1", null)));
    }

    @org.junit.jupiter.api.Test
    void existsUsername() {
        System.out.println(userService.existsUsername("test21"));
    }
}