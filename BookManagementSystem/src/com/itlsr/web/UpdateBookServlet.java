package com.itlsr.web;

import com.itlsr.domain.Book;
import com.itlsr.service.BookService;
import com.itlsr.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liusr
 * @create 2021-12-28
 * 更新书籍信息
 */
@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //书籍编号
        String bookcode = req.getParameter("bookcode");

        //书籍名
        String bookname = req.getParameter("bookname");

        //作者
        String author = req.getParameter("author");

        //书籍类型
        String bookstype = req.getParameter("bookstype");

        //入馆时间
        String entrydates = req.getParameter("entrydate");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        try {
            //类型转换
            Date entrydate = simpleDateFormat.parse(entrydates);

            //收藏地址
            String location = req.getParameter("location");

            //图书状态
            String bookstatus = req.getParameter("bookstatus");

            //图书数量
            String amount = req.getParameter("amount");

            String ids = req.getParameter("id");
            int id = Integer.parseInt(ids);

            Book book = new Book();
            book.setBookcode(bookcode);
            book.setBookname(bookname);
            book.setAuthor(author);
            book.setBookstype(bookstype);
            book.setEntrydate(entrydate);
            book.setLocation(location);
            book.setBookstatus(bookstatus);
            book.setAmount(amount);
            book.setId(id);


            //调用业务层
            BookService bookService = new BookServiceImpl();

            int i = bookService.updateBook(book);
            if (i > 0) {
                //修改成功
                req.getRequestDispatcher("/bookList").forward(req, resp);
            } else {
                req.getRequestDispatcher("/bookUpdate.jsp").forward(req, resp);
            }
        } catch (ParseException e) {
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
