package com.itlsr.dao.impl;

import com.itlsr.dao.BaseDao;
import com.itlsr.dao.UserDao;
import com.itlsr.domain.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liusr
 * @create 2021-12-27
 * 用户Dao接口实现类
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    //登录
    @Override
    public boolean login(String username, String password) throws Exception {
        boolean flag = false;
        BaseDao baseDao = new BaseDao();
        baseDao.getConnection();
        String sql = "select * from user where username=? and password=?";
        Object[] params = {username,password};
        ResultSet resultSet = this.executeSQL(sql, params);
        while (resultSet.next()){
            flag = true;
        }
        return flag;
    }

    //查询
    @Override
    public List<User> findUser(int pageNum,int pageSize,String username) throws Exception {
        //创建集合对象
        List<User> list = new ArrayList<>();
        List<Object> obj=new ArrayList<Object>();
        //创建string builder对象
        StringBuilder stringBuilder=new StringBuilder();
        //sql语句
        String sql = "select * from user";
        stringBuilder.append(sql);
        //判断，若username不为null，则加上如下sql语句，进行模糊查询
        if(username !=null && !"".equals(username)){
            stringBuilder.append(" where username like ?");
            obj.add("%"+username+"%");
        }
        //分页的sql语句
        stringBuilder.append(" limit ?,?");
        //将参数加入集合
        obj.add((pageNum-1)*pageSize);
        obj.add(pageSize);
        //创建数组
        Object[] params = obj.toArray();//将集合转为数组
        //调用方法
        ResultSet resultSet = this.executeSQL(stringBuilder.toString(), params);

        //赋值
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            user.setSex(resultSet.getString("sex"));
            user.setPhone(resultSet.getString("phone"));
            user.setAddress(resultSet.getString("address"));

            //添加到集合中
            list.add(user);
        }
        return list;
    }

    //获取总数量
    @Override
    public int getTotalCount(String username) throws Exception {
        int count = 0;
        List<Object> obj=new ArrayList<Object>();
        StringBuilder stringBuilder=new StringBuilder();
        String sql = "select count(*) from user";
        stringBuilder.append(sql);
        if(username !=null && !"".equals(username)){
            stringBuilder.append(" where username like ?");
            obj.add("%"+username+"%");
        }

        Object[] params =obj.toArray();

        ResultSet resultSet = this.executeSQL(stringBuilder.toString(), params);

        while (resultSet.next()){
            count = resultSet.getInt(1);
        }
        return count;
    }

    //查看信息
    @Override
    public User viewUser(int id) throws Exception {
        User user = new User();

        String sql = "select * from user where id=?";

        Object[] params={id};

        ResultSet resultSet = this.executeSQL(sql, params);

        while (resultSet.next()){
            user.setId(id);
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            user.setSex(resultSet.getString("sex"));
            user.setPhone(resultSet.getString("phone"));
            user.setAddress(resultSet.getString("address"));
        }

        return user;
    }

    //更新用户信息
    @Override
    public int updateUser(User user) throws Exception {

        String sql = "update user set username=?,password=?,age=?,sex=?,phone=?,address=? where id=?";

        Object[] params={user.getUsername(),user.getPassword(),user.getAge(),user.getSex(),user.getPhone(),user.getAddress(),user.getId()};

        int i = this.executeUpdate(sql, params);

        return i;


    }

    //删除用户信息
    @Override
    public int deleteUser(int id) throws Exception {
        String sql="delete from user where id=?";
        Object[] params={id};
        int i = this.executeUpdate(sql, params);
        return i;
    }

    //添加新用户
    @Override
    public int addUser(User user) throws Exception {
        String sql="insert into user(username,password,age,sex,phone,address) values(?,?,?,?,?,?)";
        Object[] params={user.getUsername(),user.getPassword(),user.getAge(),user.getSex(),user.getPhone(),user.getAddress()};
        int i = this.executeUpdate(sql, params);
        return i;
    }

}
