package com.itlsr.web;

import com.itlsr.domain.User;
import com.itlsr.service.UserService;
import com.itlsr.service.impl.UserServiceImpl;

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
@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取id
		String ids = req.getParameter("id");

		int id = Integer.parseInt(ids);

		//调用业务层
		UserService userService = new UserServiceImpl();

		try {
			User user = userService.viewUser(id);

			if (user != null) {
				//把对象存储起来
				req.setAttribute("s", user);
				//页面跳转
				req.getRequestDispatcher("/userUpdate.jsp").forward(req, resp);
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
