package com.daimamingong.common.enums;

/**
 * 邮件发送记录状态枚举
 *
 * @author robben.qu
 */
public enum MailRecordsStatusEnum {

    /**
     * 禁用
     */
    EXPIRED("-1"),

    /**
     * 未发送
     */
    UNSENT("0"),

    /**
     * 已发送
     */
    SENT("1");

    // 定义私有变量
    private String value;

    // 构造函数，枚举类型只能为私有
    private MailRecordsStatusEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
