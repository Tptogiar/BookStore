package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

public interface BookService {


    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    /**
     * 用来获取每页显示pageSize的第pageNo页
     * @param pageNo 在前要获取第pageNo页
     * @param pageSize 每页显示的数量
     * @return
     */
    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
