package com.daimamingong.service.passport;

import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.user.User;

/**
 * 账户相关业务层
 *
 * @author robben.qu
 */
public interface PassportService {

    /**
     * 注册
     *
     * @param user
     * @return
     * @throws ServiceException
     * @throws Exception
     */
    Result register(User user) throws ServiceException, Exception;

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws ServiceException
     * @throws Exception
     */
    Result login(User user) throws ServiceException, Exception;

    /**
     * 找回密码
     *
     * @param user
     * @return
     * @throws ServiceException
     * @throws Exception
     */
    Result findPassword(User user) throws ServiceException, Exception;

    /**
     * 校验用户是否已经存在
     *
     * @param userName
     * @return
     * @throws ServiceException
     * @throws Exception
     */
    Result isExists(String userName) throws ServiceException, Exception;

    /**
     * 重置密码
     *
     * @param newPassword
     * @param code
     * @return
     * @throws ServiceException
     * @throws Exception
     */
    Result resetPassword(User user, String newPassword, String code) throws ServiceException, Exception;

    /**
     * 激活
     *
     * @param code
     * @return
     * @throws ServiceException
     * @throws Exception
     */
    Result active(User user, String code) throws ServiceException, Exception;
}
