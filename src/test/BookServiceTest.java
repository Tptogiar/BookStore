package test;

import org.junit.Test;
import pojo.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        for (int i = 1; i < 101; i++) {
            String name=String.valueOf(i);
            Book book = new Book(null,name , new BigDecimal(i), "2", 2, 2, null);
            bookService.addBook(book);
        }
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(2);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(3, "test2", new BigDecimal(2), "2", 2, 2, "testPath"));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(2);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}