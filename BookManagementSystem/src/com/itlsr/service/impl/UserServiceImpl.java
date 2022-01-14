package com.itlsr.service.impl;

import com.itlsr.dao.UserDao;
import com.itlsr.dao.impl.UserDaoImpl;
import com.itlsr.domain.User;
import com.itlsr.service.UserService;

import java.util.List;

/**
 * @author liusr
 * @create 2021-12-27
 */
public class UserServiceImpl implements UserService {

    //调用dao层代码
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean login(String username, String password) throws Exception {
        return userDao.login(username,password);
    }

    @Override
    public List<User> findUser(int pageNum, int pageSize,String username) throws Exception {
        return userDao.findUser(pageNum,pageSize,username);

    }

    @Override
    public int getTotalCount(String username) throws Exception {
        return userDao.getTotalCount(username);
    }

    @Override
    public User viewUser(int id) throws Exception {
        return userDao.viewUser(id);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) throws Exception {
       return userDao.deleteUser(id);
    }

    @Override
    public int addUser(User user) throws Exception {
        return userDao.addUser(user);
    }

    @Override
    public int updatePassWord(User user) throws Exception {
        return userDao.updatePassWord(user);
    }


}
