package com.itlsr.web;

import com.itlsr.domain.User;
import com.itlsr.service.UserService;
import com.itlsr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liusr
 * @date 2022/8/12
 * @package com.itlsr.web
 */
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String ages = req.getParameter("age");
		String sex = req.getParameter("sex");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		System.out.println(username + password + ages + sex + phone + address);
		try {
			int age = Integer.parseInt(ages);
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setAge(age);
			user.setSex(sex);
			user.setPhone(phone);
			user.setAddress(address);
			UserService userService = new UserServiceImpl();
			int i = userService.addUser(user);
			if (i > 0) {
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
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
