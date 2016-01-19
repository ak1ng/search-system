package com.daimamingong.dao;

import com.daimamingong.common.exception.DataAccessException;
import com.daimamingong.model.system.UserRole;

/**
 * �û���ɫ��Ӧ��ϵ���ݷ��ʲ�
 *
 * @author robben.qu
 */
public interface UserRoleDao {

    /**
     * ɾ���û���ɫ��Ӧ��ϵ
     *
     * @param userRole
     * @return
     * @throws DataAccessException
     */
    int addUserRoleBatch(UserRole userRole) throws DataAccessException;

    /**
     * ɾ���û���ɫ��Ӧ��ϵ
     *
     * @param userRole
     * @return
     * @throws DataAccessException
     */
    int deleteUserRole(UserRole userRole) throws DataAccessException;

}
