package com.daimamingong.service.permission;

import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.system.Permission;
import com.daimamingong.model.system.Role;

import java.util.List;

/**
 * 权限业务层
 *
 * @author robben.qu
 */
public interface PermissionService {

    /**
     * 获得权限列表
     *
     * @param permission
     * @return
     */
    Result getPermissionList(Permission permission) throws ServiceException;

    /**
     * 获得权限信息
     *
     * @param permission
     * @return
     */
    Result getPermission(Permission permission) throws ServiceException;

    /**
     * 添加权限
     *
     * @param permission
     * @return
     * @throws Exception
     */
    Result addPermission(Permission permission) throws ServiceException;

    /**
     * 修改权限
     *
     * @param permission
     * @return
     * @throws Exception
     */
    Result updatePermission(Permission permission) throws ServiceException;

    /**
     * 删除权限
     *
     * @param permission
     * @return
     */
    Result deletePermission(Permission permission) throws ServiceException;

    /**
     * 获取多个角色的权限
     *
     * @param roleList
     * @return
     * @throws ServiceException
     */
    List<Permission> getRolesPermissionList(List<Role> roleList) throws ServiceException;

    /**
     * 获取菜单列表
     *
     * @param userId
     * @return
     * @throws ServiceException
     */
    Result getMenuList(Long userId) throws ServiceException;
}
