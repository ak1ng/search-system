package com.daimamingong.service.mail;

import java.util.List;

import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.model.mail.MailRecords;

public interface MailRecordsService {
	
	/**
	 * 获得邮件发送记录
	 * 
	 * @param mailRecords
	 * @return
	 * @throws ServiceException
	 * @throws Exception
	 */
	List<MailRecords> getMailRecordsList(MailRecords mailRecords) throws ServiceException,Exception;
	
	/**
	 * 修改邮件发送记录状态
	 * 
	 * @param mailRecords
	 * @return
	 * @throws ServiceException
	 * @throws Exception
	 */
	int updateMailRecordsStatus(MailRecords mailRecords) throws ServiceException,Exception;
}
