package dao;

import pojo.Book;

import java.util.List;

public interface BookDao {

    /**
     * 添加图书
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 更新图书
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 通过图书id查找图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查找全部图书
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查询图书总量
     * @return
     */
    public int  queryForPageToTotalCount();

    /**
     * 从第begin本开始，再获取pageSize本图书
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * 在价格区间min-max的范围下，从第begin本开始，再获取pageSize本图书
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

    /**
     * 查询一个在价格区间min-max的范围下共有多少本图书
     * @param min
     * @param max
     * @return
     */
    int queryForPageByPriceToTotalCount(int min,int max);
}
