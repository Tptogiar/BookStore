package web;

import dao.impl.BaseDao;
import pojo.Cart;
import pojo.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/15-12:02
 */


public class OrderServlet extends BaseServlet {


    private OrderService orderService=new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart==null){
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        if(user==null){
            req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
            return;
        }

        Integer id = user.getId();
        String orderId = null;
        try {
            orderId = orderService.createOrder(cart, id);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
        }
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/checkout.jsp");

    }
}
