package service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import pojo.*;
import service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/15-10:05
 */


public class OrderServiceImpl implements OrderService {


    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId=System.currentTimeMillis()+""+userId;

//        int i=1/0;

        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cart.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getStock()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }


        cart.clear();
        return orderId;
    }
}
