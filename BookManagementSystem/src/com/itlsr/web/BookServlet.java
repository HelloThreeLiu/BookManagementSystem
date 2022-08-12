package com.itlsr.web;

import com.itlsr.domain.Book;
import com.itlsr.service.BookService;
import com.itlsr.service.impl.BookServiceImpl;
import com.itlsr.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liusr
 * @create 2021-12-28
 */
@WebServlet("/bookList")
public class BookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//直接调用业务层代码
		BookService bookService = new BookServiceImpl();

		//获取bookname
		String bookname = req.getParameter("bookname");

		//获取当前页
		String currentPageNo = req.getParameter("pageNum");

		int pageNum = 1;
		if (null != currentPageNo && !"".equals(currentPageNo)) {
			pageNum = Integer.parseInt(currentPageNo);
		}

		//页面容量
		int pageSize = 3;

		try {
			//总页数
			PageSupport pageSupport = new PageSupport();

			//获取总数量
			int totalCount = bookService.getTotalCount(bookname);

			pageSupport.setPageNum(pageNum);
			pageSupport.setPageSize(pageSize);
			pageSupport.setTotalCount(totalCount);
			int totalPageCount = pageSupport.getTotalPageCount();//总页数

			List<Book> book = bookService.findBook(pageNum, pageSize, bookname);

			if (book.size() > 0) {
				//跳转页面
				//把集合储存到request中
				req.setAttribute("list", book);
				req.setAttribute("page", pageSupport);
				req.setAttribute("bookname", bookname);
				req.getRequestDispatcher("/bookList.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
