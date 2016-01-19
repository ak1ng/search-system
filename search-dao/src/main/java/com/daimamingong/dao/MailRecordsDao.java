package com.daimamingong.dao;

import com.daimamingong.common.exception.DataAccessException;
import com.daimamingong.model.mail.MailRecords;

import java.util.List;

/**
 * 邮件发送记录数据访问层
 *
 * @author robben.qu
 */
public interface MailRecordsDao {

    /**
     * 添加邮件记录
     *
     * @param mailRecords
     * @return
     * @throws DataAccessException
     */
    int addMailRecords(MailRecords mailRecords) throws DataAccessException;

    /**
     * 修改邮件状态
     *
     * @param mailRecords
     * @return
     * @throws DataAccessException
     */
    int updateMailRecordsStatus(MailRecords mailRecords) throws DataAccessException;

    /**
     * 获得邮件发送记录
     *
     * @param mailRecords
     * @return
     * @throws DataAccessException
     */
    MailRecords getMailRecords(MailRecords mailRecords) throws DataAccessException;

    /**
     * 获得邮件发送记录列表
     *
     * @param mailRecords
     * @return
     * @throws DataAccessException
     */
    List<MailRecords> getMailRecordsList(MailRecords mailRecords) throws DataAccessException;
}
