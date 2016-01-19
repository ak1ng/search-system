package com.daimamingong.interfaces.mail;

import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.dao.MailRecordsDao;
import com.daimamingong.model.mail.MailRecords;
import com.daimamingong.service.mail.MailRecordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件发送记录业务层
 * 
 * @author robben.qu
 * 
 */
@Service("mailRecordsService")
public class MailRecordsServiceImpl implements MailRecordsService {

	private Logger LOGGER = LoggerFactory.getLogger(MailRecordsServiceImpl.class);
	
	@Autowired
	private MailRecordsDao mailRecordsDao;

	@Override
	public List<MailRecords> getMailRecordsList(MailRecords mailRecords)
			throws ServiceException, Exception {
		LOGGER.debug("获取邮件发送记录");
		return mailRecordsDao.getMailRecordsList(mailRecords);
	}

	@Override
	public int updateMailRecordsStatus(MailRecords mailRecords)
			throws ServiceException, Exception {
		return mailRecordsDao.updateMailRecordsStatus(mailRecords);
	}

}
