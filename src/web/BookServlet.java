package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/11-13:41
 */


public class BookServlet extends BaseServlet {

    BookService bookService=new BookServiceImpl();

    protected void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        int id = WebUtils.parseInt(strId, 0);
        bookService.deleteBookById(id);
        req.getRequestDispatcher("/manager/bookServlet?action=page").forward(req,resp);
    }


    protected void edit(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        int id = WebUtils.parseInt(strId, 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }


    protected void page(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }




}
