package com.itlsr.service;

import com.itlsr.domain.Book;
import com.itlsr.domain.User;

import java.util.List;

/**
 * @author liusr
 * @create 2021-12-28
 */
public interface BookService {
    /**
     * 查询书籍
     * @return List集合
     * @throws Exception
     */
    public List<Book> findBook(int pageNum,int pageSize,String bookname) throws Exception;

    /**
     * 获取数据总数量
     * @param bookname
     * @return
     * @throws Exception
     */
    public int getTotalCount(String bookname) throws Exception;

    /**
     * 通过id查询书籍
     * @param id
     * @return
     * @throws Exception
     */
    public Book viewBook(int id) throws Exception;

    /**
     * 修改功能
     * @param book
     * @return
     * @throws Exception
     */
    public int updateBook(Book book) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteBook(int id) throws Exception;

    /**
     * 增加
     * @param book
     * @return
     * @throws Exception
     */
    public int addBook(Book book) throws Exception;

}
