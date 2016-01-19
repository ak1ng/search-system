package com.daimamingong.interfaces.user;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.dao.UserDao;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.user.User;
import com.daimamingong.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户业务层实现
 *
 * @author robben.qu
 * @since 2015年10月29日 15:55:07
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public Result addUser(User user) throws ServiceException {
        LOGGER.debug("添加用户");
        if (userDao.addUser(user) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    public Result getUser(User user) throws ServiceException {
        return new Result(ResultCode.CODE_SUCCESS, userDao.getUser(user));
    }

    public Result getUserList(User user) throws ServiceException {
        return new Result(ResultCode.CODE_SUCCESS, userDao.getUserList(user));
    }

    public Result updateUser(User user) throws ServiceException {
        if (userDao.updateUser(user) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    public Result countUser(User user) throws ServiceException {
        return new Result(ResultCode.CODE_SUCCESS, userDao.countUser(user));
    }

}
