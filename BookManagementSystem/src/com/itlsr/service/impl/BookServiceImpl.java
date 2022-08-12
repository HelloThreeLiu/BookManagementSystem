package com.itlsr.service.impl;

import com.itlsr.dao.BookDao;
import com.itlsr.dao.impl.BookDaoImpl;
import com.itlsr.domain.Book;
import com.itlsr.service.BookService;

import java.util.List;

/**
 * @author liusr
 * @create 2021-12-28
 */
public class BookServiceImpl implements BookService {

	//调用Dao层代码
	BookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> findBook(int pageNum, int pageSize, String bookname) throws Exception {
		return bookDao.findBook(pageNum, pageSize, bookname);
	}

	@Override
	public int getTotalCount(String bookname) throws Exception {
		return bookDao.getTotalCount(bookname);
	}

	@Override
	public Book viewBook(int id) throws Exception {
		return bookDao.viewBook(id);
	}

	@Override
	public int updateBook(Book book) throws Exception {
		return bookDao.updateBook(book);
	}

	@Override
	public int deleteBook(int id) throws Exception {
		return bookDao.deleteBook(id);
	}

	@Override
	public int addBook(Book book) throws Exception {
		return bookDao.addBook(book);
	}

}
