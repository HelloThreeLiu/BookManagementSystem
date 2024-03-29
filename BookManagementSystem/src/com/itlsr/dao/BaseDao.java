package com.itlsr.dao;

import java.sql.*;

/**
 * @author liusr
 * @create 2021-12-27
 * 操作数据库的工具类
 */
public class BaseDao {
    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    //创建链接(这里的端口号，用户名，密码，数据库名都要正确，否则链接不上)
    public boolean getConnection() {
        try {
            //mysql8.0需要加cj
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3333/bookmanagement?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
            connection = DriverManager.getConnection(url, "root", "20010214");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //增删改
    public int executeUpdate(String sql, Object[] params) throws SQLException {
        int count = 0;
        if (this.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            count = preparedStatement.executeUpdate();
        }
        return count;
    }

    //查询
    public ResultSet executeSQL(String sql, Object[] params) throws SQLException {
        if (this.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        }
        return resultSet;
    }
}
