package web;

import com.google.gson.Gson;
import pojo.*;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/13-16:14
 */


public class CartServlet extends BaseServlet{


    BookService bookService= new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("加入购物车");
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);
        User user = (User) req.getSession().getAttribute("user");
        if(bookId==0 || user==null){
            req.getSession().setAttribute("lastAction","当前未登录");
            resp.sendRedirect(req.getContextPath());
            return;
        }
        Book book = bookService.queryBookById(bookId);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(bookId, book.getName(), 1, book.getPrice(), book.getPrice()));
        req.getSession().setAttribute("lastAction","[ "+book.getName()+" ]加入到购物车中");
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("从购物车中删除");

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
            Book book = bookService.queryBookById(id);
            req.getSession().setAttribute("lastAction","[ "+book.getName()+" ]从购物车中删除");
            resp.sendRedirect(req.getHeader("Referer"));
        }


    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("更新");
        int id = WebUtils.parseInt(req.getParameter("id"), -1);
        int count = WebUtils.parseInt(req.getParameter("count"), -1);
        if(id==-1 || count==-1){
            resp.sendRedirect(req.getHeader("Referer"));
            return;
        }
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clearItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("清空购物车");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }


    protected void ajaxAddToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxAddToCart加入购物车");
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);
        User user = (User) req.getSession().getAttribute("user");
        if(bookId==0 || user==null){
            req.getSession().setAttribute("lastAction","当前未登录");
            resp.sendRedirect(req.getContextPath());
            return;
        }
        Book book = bookService.queryBookById(bookId);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(bookId, book.getName(), 1, book.getPrice(), book.getPrice()));
        req.getSession().setAttribute("lastAction","[ "+book.getName()+" ]加入到购物车中");

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("lastAction","[ "+book.getName()+" ]加入到购物车中");
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("totalPrice",cart.getTotalPrice());

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
//        resp.sendRedirect(req.getHeader("Referer"));
    }



}
