package com.daimamingong.interfaces.passport;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.common.enums.MailRecordsStatusEnum;
import com.daimamingong.common.enums.MailRecordsTypeEnum;
import com.daimamingong.common.enums.UserStatusEnum;
import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.common.util.DateUtils;
import com.daimamingong.common.util.MD5Utils;
import com.daimamingong.dao.MailRecordsDao;
import com.daimamingong.dao.UserDao;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.mail.MailRecords;
import com.daimamingong.model.user.User;
import com.daimamingong.service.passport.PassportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 帐号操作相关业务层实现
 *
 * @author robben.qu
 */
@Service("passportService")
public class PassportServiceImpl implements PassportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PassportServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private MailRecordsDao mailRecordsDao;

    @Override
    public Result register(User user) throws Exception {
        LOGGER.debug("用户注册");
        // 将用户密码加密
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setUserStatus(UserStatusEnum.NONACTIVATED.value());
        user.setEmail(user.getUsername());

        // 校验邮箱是否已被注册
        if (userDao.isExists(user.getUsername()) > 0)
            return new Result(ResultCode.CODE_EMAIL_HAS_BEEN_REGISTERED);

        // 添加用户信息
        if (userDao.addUser(user) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    @Override
    public Result login(User user) throws Exception {
        LOGGER.debug("登录业务处理");
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        if (null == userDao.getUser(user))
            return new Result(ResultCode.CODE_USER_NOT_EXIST_OR_PASSWORD_NOT_CORRECT);

        return new Result(ResultCode.CODE_SUCCESS);
    }

    @Override
    public Result findPassword(User user) throws Exception {
        // 校验用户是否存在
        user = userDao.getUser(user);
        if (null == user)
            return new Result(ResultCode.CODE_FAIL);

        // 添加邮件发送记录
        MailRecords mailRecords = new MailRecords();
        mailRecords.setUserId(user.getUserId());
        mailRecords.setCode(MD5Utils.encrypt(user.getUsername()));
        mailRecords.setMailStatus(MailRecordsStatusEnum.UNSENT.value());
        mailRecords.setMailType(MailRecordsTypeEnum.FIND_PASSWORD.value());
        if (mailRecordsDao.addMailRecords(mailRecords) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    @Override
    public Result isExists(String userName) throws Exception {
        LOGGER.debug("检查用户是否已经存在");
        if (userDao.isExists(userName) > 0)
            return new Result(ResultCode.CODE_FAIL);

        return new Result(ResultCode.CODE_SUCCESS);
    }

    @Override
    public Result resetPassword(User user, String newPassword, String code) throws Exception {
        LOGGER.debug("重置密码");
        // 检查用户是否发送过重置密码邮件
        MailRecords mailRecords = new MailRecords();
        mailRecords.setCode(code);
        mailRecords.setMailType(MailRecordsTypeEnum.FIND_PASSWORD.value());
        mailRecords.setMailStatus(MailRecordsStatusEnum.SENT.value());
        mailRecords = mailRecordsDao.getMailRecords(mailRecords);
        if (null == mailRecords)
            return new Result(ResultCode.CODE_FAIL);

        // 有效时长为24小时
        Long duration = Long.valueOf(1000 * 60 * 60 * 24);
        // 检查激活链接是否已过期
        if (DateUtils.isExpires(mailRecords.getCreateTime(), duration))
            return new Result(ResultCode.CODE_FAIL);

        // 获取用户信息
        user = userDao.getUser(user);
        if (null == user)
            return new Result(ResultCode.CODE_FAIL);

        // 修改密码
        user.setPassword(newPassword);
        if (userDao.updateUser(user) > 0)
            return new Result(ResultCode.CODE_SUCCESS);
        return new Result(ResultCode.CODE_FAIL);
    }

    @Override
    public Result active(User user, String code) throws ServiceException, Exception {
        // 检查用户激活链接是否有效
        MailRecords mailRecords = new MailRecords();
        mailRecords.setCode(code);
        mailRecords.setMailStatus(MailRecordsStatusEnum.SENT.value());
        mailRecords.setMailType(MailRecordsTypeEnum.REGISTER.value());
        mailRecords = mailRecordsDao.getMailRecords(mailRecords);
        if (null == mailRecords || mailRecords.getMailRecordsId() <= 0)
            return new Result(ResultCode.CODE_ILLEGAL_REQUEST);

        // 有效时长为24小时
        Long duration = Long.valueOf(1000 * 60 * 60 * 24);
        // 检查激活链接是否已过期
        if (DateUtils.isExpires(mailRecords.getCreateTime(), duration))
            return new Result(ResultCode.CODE_FAIL);

        // 将邮件记录设置状态设置为已过期
        mailRecords.setMailStatus(MailRecordsStatusEnum.UNSENT.value());
        if (mailRecordsDao.updateMailRecordsStatus(mailRecords) <= 0)
            return new Result(ResultCode.CODE_FAIL);

        // 修改用户状态为正常
        if (userDao.updateUserStatus(user) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }
}
