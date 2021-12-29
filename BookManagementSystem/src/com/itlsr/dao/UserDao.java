package com.itlsr.dao;

import com.itlsr.domain.User;

import java.util.List;

/**
 * @author liusr
 * @create 2021-12-27
 */
public interface UserDao {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return 布尔值
     * @throws Exception
     */
    public boolean login(String username,String password) throws Exception;

    /**
     * 查询并分页显示
     * @param pageNum 当前页面
     * @param pageSize 页面容量
     * @return
     * @throws Exception
     */
    public List<User> findUser(int pageNum,int pageSize,String username) throws Exception;

    /**
     * 获取数据总数量
     * @return
     * @throws Exception
     */
    public int getTotalCount(String username) throws Exception;

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User viewUser(int id) throws Exception;

    /**
     * 修改功能
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(int id) throws Exception;

    /**
     * 增加
     * @param user
     * @return
     * @throws Exception
     */
    public int addUser(User user) throws Exception;

}

