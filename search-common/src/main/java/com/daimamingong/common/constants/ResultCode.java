package com.daimamingong.common.constants;

/**
 * 接口响应码
 *
 * @author robben.qu
 */
public interface ResultCode {

    /**
     * 响应码前缀
     */
    static final String MESSAGE_CODE_PREFIX = "message.code.";

    /**
     * 非法的请求
     */
    String CODE_ILLEGAL_REQUEST = "-999999";

    /**
     * 系统异常
     */
    String CODE_SYSTEM_ERROR = "-1";

    /**
     * 成功
     */
    String CODE_SUCCESS = "0";

    /**
     * 失败
     */
    String CODE_FAIL = "1";

    /**
     * 缺少参数
     */
    String CODE_PARAMS_MISS = "100001";

    /**
     * 参数错误
     */
    String CODE_PARAMETER_INVALID = "100002";

    /**
     * 邮件格式错误
     */
    String CODE_EMAIL_FORMAT_ERROR = "100003";

    /**
     * 密码长度必须在6~16位之间
     */
    String CODE_PASSWORD_LENGTH_BETWEEN_6_AND_16 = "100004";

    /**
     * 用户不能存在或密码错误
     */
    String CODE_USER_NOT_EXIST_OR_PASSWORD_NOT_CORRECT = "100005";

    /**
     * 邮箱已经被注册
     */
    String CODE_EMAIL_HAS_BEEN_REGISTERED = "100006";
}
