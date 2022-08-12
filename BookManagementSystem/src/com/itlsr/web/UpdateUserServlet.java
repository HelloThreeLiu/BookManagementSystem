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
import java.text.ParseException;

/**
 * @author liusr
 * @create 2021-12-28
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户名
		String username = req.getParameter("username");

		//密码
		String password = req.getParameter("password");

		//性别
		String sex = req.getParameter("sex");
		try {

			//年龄
			String ages = req.getParameter("age");
			int age = Integer.parseInt(ages);

			//电话
			String phone = req.getParameter("phone");

			//地址
			String address = req.getParameter("address");

			int id = Integer.parseInt(req.getParameter("id"));

			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setAge(age);
			user.setSex(sex);
			user.setPhone(phone);
			user.setAddress(address);
			user.setId(id);


			//调用业务层
			UserService userService = new UserServiceImpl();

			int i = userService.updateUser(user);
			if (i > 0) {
				//修改成功
				req.getRequestDispatcher("/userList").forward(req, resp);
			} else {
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
