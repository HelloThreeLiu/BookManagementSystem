package com.itlsr.service;

import com.itlsr.domain.User;

import java.util.List;

/**
 * @author liusr
 * @create 2021-12-27
 */
public interface UserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean login(String username,String password) throws Exception;

    /**
     * 用户查询，分页显示
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<User> findUser(int pageNum,int pageSize,String username) throws Exception;

    /**
     * 获取总数量
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

    /**
     * 修改密码
     * @param user
     * @return
     * @throws Exception
     */
    public int updatePassWord(User user) throws Exception;
}
