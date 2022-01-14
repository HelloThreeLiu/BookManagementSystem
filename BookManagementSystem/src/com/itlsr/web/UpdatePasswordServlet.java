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
 * @create 2022-01-10
 */
@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取旧密码
        String oldPassword = req.getParameter("oldPassword");

        //获取新密码
        String newPassword = req.getParameter("newPassword");

        //获取确认密码
        String reNewPassword = req.getParameter("reNewPassword");

        try {
            String ids = req.getParameter("id");
            int id = Integer.parseInt(ids);
            User user = new User();
            //判断密码是否一样
            if (user.getPassword().equals(oldPassword)){
                //判断新密码是否和确认密码一样
                if (newPassword.equals(reNewPassword)){
                    user.setPassword(newPassword);
                    user.setId(id);
                }else {
                    req.getRequestDispatcher("/updatePassword.jsp").forward(req,resp);
                }
            }else {
                req.getRequestDispatcher("/updatePassword.jsp").forward(req,resp);
            }


            UserService userService = new UserServiceImpl();
            int i = userService.updatePassWord(user);

            //判断是否修改成功
            if(i>0){
                //修改成功
                req.getRequestDispatcher("/userList").forward(req,resp);
            }else{
                req.getRequestDispatcher("/updatePassword.jsp").forward(req,resp);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
