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
 * @create 2021-12-29
 */
@WebServlet("/passwordServlet")
public class PasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String password = req.getParameter("password");
        /*String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        System.out.println(password);*/
        try {
            User user=new User();
            user.setPassword(password);
//            user.setId(id);

            //调用业务层
            UserService userService=new UserServiceImpl();
            int i = userService.updatePassword(user);
            if (i>0){
                //修改成功
                System.out.println(1);
                req.getRequestDispatcher("/userList").forward(req,resp);
            }else {
                System.out.println(0);
                req.getRequestDispatcher("/password.jsp").forward(req,resp);
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
