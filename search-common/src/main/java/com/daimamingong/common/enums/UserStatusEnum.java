package com.daimamingong.common.enums;

/**
 * 用户状态枚举
 * @author robben.qu
 */
public enum UserStatusEnum {

    /**
     * 禁用
     */
    DISABLED("-1"),

    /**
     * 未激活
     */
    NONACTIVATED("0"),

    /**
     * 正常
     */
    NORMAL("1");

    // 定义私有变量
    private String nCode;

    // 构造函数，枚举类型只能为私有
    private UserStatusEnum(String _nCode) {
        this.nCode = _nCode;
    }

    public String value() {
        return this.nCode;
    }
}
