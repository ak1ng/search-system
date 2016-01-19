package com.daimamingong.dao;

import com.daimamingong.common.exception.DataAccessException;
import com.daimamingong.model.system.Role;
import com.daimamingong.model.system.UserRole;

import java.util.List;

/**
 * 角色相关数据访问层
 *
 * @author robben.qu
 */
public interface RoleDao {

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws DataAccessException
     */
    int addRole(Role role) throws DataAccessException;

    /**
     * 修改角色
     *
     * @param role
     * @return
     * @throws DataAccessException
     */
    int updateRole(Role role) throws DataAccessException;

    /**
     * 获得角色
     *
     * @param role
     * @return
     * @throws DataAccessException
     */
    Role getRole(Role role) throws DataAccessException;

    /**
     * 获得角色列表
     *
     * @param role
     * @return
     * @throws DataAccessException
     */
    List<Role> getRoleList(Role role) throws DataAccessException;

    /**
     * 获得用户角色信息
     *
     * @param userRole
     * @return
     * @throws DataAccessException
     */
    List<Role> getUserRoleList(UserRole userRole) throws DataAccessException;

}
