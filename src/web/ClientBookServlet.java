package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/11-23:21
 */


public class ClientBookServlet extends BaseServlet {

    BookService bookService=new BookServiceImpl();


    protected void page(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        int min=WebUtils.parseInt(req.getParameter("min"),0);
        int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        if(max<min){
            int temp=min;
            min=max;
            max=temp;
        }
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder url=new StringBuilder("client/bookServlet?action=pageByPrice");
        url.append("&min=").append(String.valueOf(min)).append("&max=").append(String.valueOf(max));
        page.setUrl(url.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
