package dao.impl;

import dao.BookDao;
import pojo.Book;
import web.BaseServlet;

import java.util.List;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/11-12:52
 */


public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(Book book) {
        String sql="insert into t_book (`name`,`author`,`price`,`sales`,`stock`,`img_path`)" +
                "values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),
        book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set `name`= ?,`author`=?,`price`=?,`sales`= ?,`stock`= ?,`img_path`= ? where id= ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),
                book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select * from t_book where id=?";
       return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select * from t_book";
       return queryForlist(Book.class,sql);
    }

    @Override
    public int queryForPageToTotalCount() {
        String sql="select count(*) from t_book";
        Number count = (Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql="select * from t_book limit ?,?";
        return queryForlist(Book.class,sql,begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select * from t_book where `price` between ? and ? order by `price` limit ? , ?";
        return queryForlist(Book.class,sql,min,max,begin,pageSize);
    }

    @Override
    public int queryForPageByPriceToTotalCount(int min,int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSingleValue(sql, min, max);
        return number.intValue();
    }
}
