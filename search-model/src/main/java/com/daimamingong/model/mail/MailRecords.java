package com.daimamingong.model.mail;

import com.daimamingong.model.Pager;

/**
 * 邮件记录
 * 
 * @author robben.qu
 */
public class MailRecords extends Pager<MailRecords> {

	private static final long serialVersionUID = 7496975786936342523L;

	/**
	 * 主键
	 */
	private Long mailRecordsId;

	/**
	 * 用户名
	 */
	private Long userId;

	/**
	 * 邮件地址
	 */
	private String email;

	/**
	 * 密钥
	 */
	private String code;

	/**
	 * 邮件类型
	 */
	private String mailType;

	/**
	 * 邮件状态
	 */
	private String mailStatus;

	public Long getMailRecordsId() {
		return mailRecordsId;
	}

	public void setMailRecordsId(Long mailRecordsId) {
		this.mailRecordsId = mailRecordsId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public String getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}

}
