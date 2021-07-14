package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.Page;
import service.BookService;

import java.util.List;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/11-13:22
 */


public class BookServiceImpl implements BookService {

    BookDao bookDao=new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> bookPage = new Page<>();

        bookPage.setPageSize(pageSize);
        int pageToTotalCount=bookDao.queryForPageToTotalCount();
        bookPage.setPageTotalCount(pageToTotalCount);
        bookPage.setPageTotal();

        bookPage.setPageNo(pageNo);
        int begin=(bookPage.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize);
        bookPage.setItems(items);
        return bookPage;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        int pageToTotalCount=bookDao.queryForPageByPriceToTotalCount(min,max);
        bookPage.setPageTotalCount(pageToTotalCount);
        bookPage.setPageTotal();
        bookPage.setPageNo(pageNo);
        int begin=(bookPage.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        bookPage.setItems(items);
        return bookPage;
    }
}
