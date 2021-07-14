package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.jupiter.api.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

    BookDao bookDao=new BookDaoImpl();
    @Test
    void addBook() {
        bookDao.addBook(new Book(null,"test",new BigDecimal(98),"me",23,25,null));
    }

    @Test
    void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    void updateBook() {
        bookDao.updateBook(new Book(22,"testtest",new BigDecimal(2),"meme",2,2,""));

    }

    @Test
    void queryBookById() {
        Book book = bookDao.queryBookById(22);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}