package com.daimamingong.dao;

import com.daimamingong.common.exception.DataAccessException;
import com.daimamingong.model.system.RolePermission;

/**
 * ��ɫȨ�޶�Ӧ��ϵ���ݷ��ʲ�
 *
 * @author robben.qu
 */
public interface RolePermissionDao {

    /**
     * ������ӽ�ɫȨ�޶�Ӧ��ϵ
     *
     * @param rolePermission
     * @return
     * @throws DataAccessException
     */
    int addRolePermissionBatch(RolePermission rolePermission) throws DataAccessException;

    /**
     * ����ɾ����ɫȨ�޶�Ӧ��ϵ
     *
     * @param rolePermission
     * @return
     * @throws DataAccessException
     */
    int deleteRolePermission(RolePermission rolePermission) throws DataAccessException;
}
