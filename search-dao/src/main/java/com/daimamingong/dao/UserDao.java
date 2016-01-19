package com.daimamingong.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.daimamingong.common.exception.DataAccessException;
import com.daimamingong.model.user.User;

/**
 * 用户信息数据访问层
 *
 * @author robben.qu
 * @since 2015年10月29日 15:57:04
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    int addUser(User user) throws DataAccessException;

    /**
     * 校验用户是否已经存在
     *
     * @param userName
     * @return
     * @throws DataAccessException
     */
    int isExists(String userName) throws DataAccessException;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    int updateUser(User user) throws DataAccessException;

    /**
     * 获得用户信息
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    User getUser(User user) throws DataAccessException;

    /**
     * 统计用户总数
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    int countUser(User user) throws DataAccessException;

    /**
     * 获得用户列表
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    List<User> getUserList(User user) throws DataAccessException;

    /**
     * 获得用户列表
     *
     * @param user
     * @param rowBounds
     * @return
     * @throws DataAccessException
     */
    Page<User> getUserList(User user, RowBounds rowBounds) throws DataAccessException;

    /**
     * 修改用户状态
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    int updateUserStatus(User user) throws DataAccessException;
}
