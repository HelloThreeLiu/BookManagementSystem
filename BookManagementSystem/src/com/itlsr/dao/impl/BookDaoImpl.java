package com.itlsr.dao.impl;

import com.itlsr.dao.BaseDao;
import com.itlsr.dao.BookDao;
import com.itlsr.domain.Book;
import com.itlsr.domain.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liusr
 * @create 2021-12-28
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public List<Book> findBook(int pageNum,int pageSize,String bookname) throws Exception {
        //创建集合对象
        List<Book> list = new ArrayList<>();
        List<Object> obj = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        //sql语句
        String sql = "select * from book";
        stringBuilder.append(sql);
        if (bookname != null && !"".equals(bookname)){
            stringBuilder.append(" where bookname like?");
            obj.add("%"+bookname+"%");
        }
        stringBuilder.append(" limit ?,?");
        obj.add((pageNum-1)*pageSize);
        obj.add(pageSize);
        //创建数组
        Object[] params = obj.toArray();
        //调用方法
        ResultSet resultSet = this.executeSQL(stringBuilder.toString(), params);

        //赋值
        while (resultSet.next()){
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setBookcode(resultSet.getString("bookcode"));
            book.setBookname(resultSet.getString("bookname"));
            book.setAuthor(resultSet.getString("author"));
            book.setBookstype(resultSet.getString("bookstype"));
            book.setEntrydate(resultSet.getDate("entrydate"));
            book.setLocation(resultSet.getString("location"));
            book.setBookstatus(resultSet.getString("bookstatus"));
            book.setAmount(resultSet.getString("amount"));

            list.add(book);
        }
        return list;
    }

    @Override
    public int getTotalCount(String bookname) throws Exception {
        int count = 0;
        List<Object> obj=new ArrayList<Object>();
        StringBuilder stringBuilder=new StringBuilder();
        String sql = "select count(*) from book";
        stringBuilder.append(sql);
        if(bookname !=null && !"".equals(bookname)){
            stringBuilder.append(" where bookname like ?");
            obj.add("%"+bookname+"%");
        }

        Object[] params =obj.toArray();

        ResultSet resultSet = this.executeSQL(stringBuilder.toString(), params);

        while (resultSet.next()){
            count = resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public Book viewBook(int id) throws Exception {
        Book book = new Book();

        String sql = "select * from book where id=?";

        Object[] params={id};

        ResultSet resultSet = this.executeSQL(sql, params);

        while (resultSet.next()){
           book.setId(id);
           book.setBookcode(resultSet.getString("bookcode"));
           book.setBookname(resultSet.getString("bookname"));
           book.setAuthor(resultSet.getString("author"));
           book.setBookstype(resultSet.getString("bookstype"));
           book.setEntrydate(resultSet.getDate("entrydate"));
           book.setLocation(resultSet.getString("location"));
           book.setBookstatus(resultSet.getString("bookstatus"));
           book.setAmount(resultSet.getString("amount"));
        }

        return book;
    }

    @Override
    public int updateBook(Book book) throws Exception {
        String sql = "update book set bookcode=?,bookname=?,author=?,bookstype=?,entrydate=?,location=?,bookstatus=?,amount=? where id=?";

        Object[] params={book.getBookcode(),book.getBookname(),book.getAuthor(),book.getBookstype(),book.getEntrydate(),book.getLocation(),book.getBookstatus(),book.getAmount(),book.getId()};

        int i = this.executeUpdate(sql, params);

        return i;
    }

    @Override
    public int deleteBook(int id) throws Exception {
        String sql="delete from book where id=?";
        Object[] params={id};
        int i = this.executeUpdate(sql, params);
        return i;
    }

    @Override
    public int addBook(Book book) throws Exception {
        String sql="insert into book(bookcode,bookname,author,bookstype,entrydate,location,bookstatus,amount) values(?,?,?,?,?,?,?,?)";
        Object[] params={book.getBookcode(),book.getBookname(),book.getAuthor(),book.getBookstype(),book.getEntrydate(),book.getLocation(),book.getBookstatus(),book.getAmount()};
        int i = this.executeUpdate(sql, params);
        return i;
    }
}
