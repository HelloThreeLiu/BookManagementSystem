package com.itlsr.web;

import com.itlsr.domain.Book;
import com.itlsr.domain.User;
import com.itlsr.service.BookService;
import com.itlsr.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liusr
 * @create 2021-12-28
 */
@WebServlet("/viewBookServlet")
public class ViewBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取id
		String id = req.getParameter("id");

		int ids = Integer.parseInt(id);

		//调用业务层
		BookService bookService = new BookServiceImpl();

		try {
			Book book = bookService.viewBook(ids);

			if (book != null) {
				//把对象存储起来
				req.setAttribute("book", book);
				//页面跳转
				req.getRequestDispatcher("/bookView.jsp").forward(req, resp);
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
