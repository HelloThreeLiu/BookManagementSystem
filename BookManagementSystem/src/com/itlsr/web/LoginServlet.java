package com.itlsr.web;

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
 * @create 2021-12-27
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取用户名
        String username = req.getParameter("username");
        System.out.println(username);
        //获取密码
        String password = req.getParameter("password");
        System.out.println(password);
        //调用业务层代码
        UserService userService = new UserServiceImpl();

        try {
            boolean login = userService.login(username, password);
            if (login){
                System.out.println("登录成功");
                //登录成功
                //页面跳转到新的首页中
                //把用户名在session（会话）中存起来
                HttpSession session = req.getSession();
                session.setAttribute("name",username);
                req.getRequestDispatcher("/welcome.jsp").forward(req,resp);
            }else{
                System.out.println("登录失败");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
