package com.daimamingong.service.user;

import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.user.User;


/**
 * 用户业务层
 *
 * @author robben.qu
 * @since 2015年10月29日 15:54:41
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws ServiceException
     */
    Result addUser(User user) throws ServiceException;

    /**
     * 更新用户
     *
     * @param user
     * @return
     * @throws ServiceException
     */
    Result updateUser(User user) throws ServiceException;

    /**
     * 获得用户信息
     *
     * @param user
     * @return
     * @throws ServiceException
     */
    Result getUser(User user) throws ServiceException;

    /**
     * 统计用户个数
     *
     * @param user
     * @return
     * @throws ServiceException
     */
    Result countUser(User user) throws ServiceException;

    /**
     * 获得用户列表
     *
     * @param user
     * @return
     * @throws ServiceException
     */
    Result getUserList(User user) throws ServiceException;

}
