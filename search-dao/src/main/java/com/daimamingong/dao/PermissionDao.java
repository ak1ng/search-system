package com.daimamingong.dao;

import com.daimamingong.common.exception.DataAccessException;
import com.daimamingong.model.system.Permission;
import com.daimamingong.model.system.Role;

import java.util.List;

/**
 * 权限数据访问层
 *
 * @author robben.qu
 */
public interface PermissionDao {

    /**
     * 添加权限
     *
     * @param permission
     * @return
     * @throws DataAccessException
     */
    int addPermission(Permission permission) throws DataAccessException;

    /**
     * 获得权限列表
     *
     * @param permission
     * @return
     */
    List<Permission> getPermissionList(Permission permission) throws DataAccessException;

    /**
     * 获得权限信息
     *
     * @param permission
     * @return
     */
    Permission getPermission(Permission permission) throws DataAccessException;

    /**
     * 修改权限信息
     *
     * @param permission
     * @return
     * @throws DataAccessException
     */
    int updatePermission(Permission permission) throws DataAccessException;

    /**
     * 获取多个角色的权限
     *
     * @param roleList
     * @return
     * @throws DataAccessException
     */
    List<Permission> getPermissionListByRoles(List<Role> roleList) throws DataAccessException;

    /**
     * 获取用户角色列表
     *
     * @param userId
     * @return
     * @throws DataAccessException
     */
    List<Permission> getPermissionListByUserId(Long userId) throws DataAccessException;

}
