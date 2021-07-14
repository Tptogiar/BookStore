package web;

import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/13-16:14
 */


public class CatrServlet extends BaseServlet{


    BookService bookService= new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("加入购物车");
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        if(id==0){
            return;
        }
        Book book = bookService.queryBookById(id);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(id,book.getName(),1,book.getPrice(),book.getPrice()));
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("从购物车中删除");

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
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

    protected void getCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("查看购物车");
//        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
//        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
//        Page<CartItem> cartItemPage = new Page<>();
//        cartItemPage.setPageSize(pageSize);
//        cartItemPage.setPageTotalCount(cart.getItems().size());
//        cartItemPage.setPageTotal();
//        cartItemPage.setPageNo(pageNo);
//        Collection<CartItem>cartItemCollectionms = cart.getItems().values();
//        ArrayList<CartItem> cartItems = new ArrayList<>(cartItemCollectionms);
//        int begin=0;
//        for (int i = begin; i <begin+pageSize; i++) {
//            cartItems.get(i-1);
//        }
//        cartItemPage.setItems(cartItems);
//        req.getSession().setAttribute("cart",cart);
//        req.getRequestDispatcher("/pages/cart.jsp").forward(req,resp);
    }


}
