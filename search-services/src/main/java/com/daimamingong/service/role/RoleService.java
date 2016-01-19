package com.daimamingong.service.role;

import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.system.Role;
import com.daimamingong.model.system.UserRole;

import java.util.List;

/**
 * 角色相关业务层
 *
 * @author robben.qu
 */
public interface RoleService {

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    Result addRole(Role role) throws ServiceException;

    /**
     * 修改角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    Result updateRole(Role role) throws ServiceException;

    /**
     * 删除角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    Result deleteRole(Role role) throws ServiceException;

    /**
     * 获得角色列表
     *
     * @param role
     * @return
     * @throws Exception
     */
    Result getRoleList(Role role) throws ServiceException;

    /**
     * 获得角色信息
     *
     * @param role
     * @return
     * @throws Exception
     */
    Result getRole(Role role) throws ServiceException;

    /**
     * 获取用户所有角色信息
     *
     * @param userRole
     * @return
     * @throws ServiceException
     */
    List<Role> getUserRoleList(UserRole userRole) throws ServiceException;

    /**
     * 获得角色的所有权限
     *
     * @param roleList
     * @return
     */
    Result getPermissionListByRoles(List<Role> roleList) throws ServiceException;
}
