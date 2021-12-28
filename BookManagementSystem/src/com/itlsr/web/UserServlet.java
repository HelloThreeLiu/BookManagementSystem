package com.itlsr.web;

import com.itlsr.domain.User;
import com.itlsr.service.UserService;
import com.itlsr.service.impl.UserServiceImpl;
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
 * @create 2021-12-27
 */
@WebServlet("/userList")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //直接调用业务层代码
        UserService userService = new UserServiceImpl();

        //获取username
        String username=req.getParameter("username");

        //获取当前叶
        String currentPageNo = req.getParameter("pageNum");

        System.out.println(currentPageNo+"=========");

        int pageNum = 1;
        if (null != currentPageNo && !"".equals(currentPageNo)){
            pageNum=Integer.parseInt(currentPageNo);//把字符串类型强制转换为int
        }

        System.out.println(pageNum+"========");

        //页面容量
        int pageSize = 3;


        try {
            //总页数
            PageSupport pageSupport = new PageSupport();

            //获取总数量
            int totalCount = userService.getTotalCount(username);

            pageSupport.setPageNum(pageNum);
            pageSupport.setPageSize(pageSize);
            pageSupport.setTotalCount(totalCount);
            int totalPageCount = pageSupport.getTotalPageCount();//总页数

            List<User> user = userService.findUser(pageNum,pageSize,username);

            //查询不用传数据

            if (user.size()>0){
                //跳转页面
                //把集合存储到request中
                req.setAttribute("list",user);
                req.setAttribute("page",pageSupport);
                req.setAttribute("username",username);
                req.getRequestDispatcher("/userList.jsp").forward(req,resp);
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
