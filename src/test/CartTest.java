package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart+"  \n"+cart.getTotalCount()+"  \n"+cart.getTotalPrice());
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);
        System.out.println(cart+"  \n"+cart.getTotalCount()+"  \n"+cart.getTotalPrice());
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);
        cart.clear();
        System.out.println(cart+"  \n"+cart.getTotalCount()+"  \n"+cart.getTotalPrice());
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.updateCount(1,2);
        System.out.println(cart+"  \n"+cart.getTotalCount()+"  \n"+cart.getTotalPrice());
    }

    @Test
    public void getTotalCount() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"test2",1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        cart.addItem(new CartItem(1,"test1",0,new BigDecimal(10),new BigDecimal(0)));
        cart.updateCount(1,2);
        System.out.println(cart+"  \n"+cart.getTotalCount()+"  \n"+cart.getTotalPrice());

    }
}