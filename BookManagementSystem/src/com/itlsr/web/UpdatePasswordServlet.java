package com.itlsr.web;

import com.itlsr.domain.User;
import com.itlsr.service.UserService;
import com.itlsr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liusr
 * @create 2022-01-10
 */
@WebServlet("/passwordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		String reNewPassword = req.getParameter("reNewPassword");
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("name");
		try {
			//调用业务层
			UserService userService = new UserServiceImpl();
			User user = userService.selectUserByUsername(username);
			String password = user.getPassword();
			if (!password.equals(oldPassword)) {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
			if (!newPassword.equals(reNewPassword)) {
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
			user.setPassword(newPassword);
			int i = userService.updatePassWord(user);
			if (i > 0) {
				//修改成功
				System.out.println(1);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			} else {
				System.out.println(0);
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
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
