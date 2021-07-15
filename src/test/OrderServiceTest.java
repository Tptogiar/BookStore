package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));

        OrderServiceImpl orderService = new OrderServiceImpl();
        String orderId = orderService.createOrder(cart, 1);

        System.out.println(orderId);


    }
}