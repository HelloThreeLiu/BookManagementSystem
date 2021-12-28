package com.itlsr.web;

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
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        String ids=req.getParameter("id");
        int id=Integer.parseInt(ids);

        BookService bookService = new BookServiceImpl();

        try {
            int i = bookService.deleteBook(id);
            if(i>0){
                //删除成功
                req.getRequestDispatcher("/bookList").forward(req,resp);
            }else {
                //删除失败
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
