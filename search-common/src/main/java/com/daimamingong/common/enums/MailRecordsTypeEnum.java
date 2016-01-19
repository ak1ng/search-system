package com.daimamingong.common.enums;

/**
 * 邮件发送记录类型枚举
 * 
 * @author robben.qu
 */
public enum MailRecordsTypeEnum {

	/**
	 * 注册
	 */
	REGISTER("0"),

	/**
	 * 密码找回
	 */
	FIND_PASSWORD("1");

	// 定义私有变量
	private String value;

	// 构造函数，枚举类型只能为私有
	private MailRecordsTypeEnum(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

}
