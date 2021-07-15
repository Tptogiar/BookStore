package test;

import dao.impl.OrderItemDaoImpl;
import org.junit.Test;
import pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"test",1,new BigDecimal(100),new BigDecimal(100),"1234567891"));



    }
}