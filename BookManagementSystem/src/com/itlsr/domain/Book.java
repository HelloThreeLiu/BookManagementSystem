package com.itlsr.domain;

import java.util.Date;

/**
 * @author liusr
 * @create 2021-12-27
 * 书籍类
 */
public class Book {
    private int id;//书籍id
    private String bookcode;//书籍编码
    private String bookname;//书籍名称
    private String author;//作者
    private String bookstype;//书籍类型
    private Date entrydate;//入馆时间
    private String location;//馆藏地址
    private String bookstatus;//书籍状态
    private String amount;//书籍数量

    public Book() {
        this.id = id;
        this.bookcode = bookcode;
        this.bookname = bookname;
        this.author = author;
        this.bookstype = bookstype;
        this.entrydate = entrydate;
        this.location = location;
        this.bookstatus = bookstatus;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookcode() {
        return bookcode;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookstype() {
        return bookstype;
    }

    public void setBookstype(String bookstype) {
        this.bookstype = bookstype;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
