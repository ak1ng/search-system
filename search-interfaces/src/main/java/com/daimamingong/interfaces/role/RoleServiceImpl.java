package com.daimamingong.interfaces.role;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.common.enums.RoleStatusEnum;
import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.dao.PermissionDao;
import com.daimamingong.dao.RoleDao;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.system.Role;
import com.daimamingong.model.system.UserRole;
import com.daimamingong.service.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色相关业务层实现
 *
 * @author robben.qu
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Result addRole(Role role) throws ServiceException {
        LOGGER.debug("添加角色");
        if (roleDao.addRole(role) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    @Override
    public Result updateRole(Role role) throws ServiceException {
        LOGGER.debug("修改角色");
        if (roleDao.updateRole(role) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    @Override
    public Result deleteRole(Role role) throws ServiceException {
        LOGGER.debug("删除角色");
        role.setRoleEnable(RoleStatusEnum.DISABLED.value());
        if (roleDao.updateRole(role) <= 0)
            return new Result(ResultCode.CODE_FAIL);

        return new Result(ResultCode.CODE_FAIL);
    }

    @Override
    public Result getRole(Role role) throws ServiceException {
        LOGGER.debug("获得角色信息");
        return new Result(ResultCode.CODE_SUCCESS, roleDao.getRole(role));
    }

    @Override
    public Result getRoleList(Role role) throws ServiceException {
        LOGGER.debug("获得角色信息列表");
        return new Result(ResultCode.CODE_SUCCESS, roleDao.getRoleList(role));
    }

    @Override
    public Result getPermissionListByRoles(List<Role> roleList) throws ServiceException {
        LOGGER.debug("获得角色的权限信息");
        return new Result(ResultCode.CODE_SUCCESS, permissionDao.getPermissionListByRoles(roleList));
    }

    @Override
    public List<Role> getUserRoleList(UserRole userRole) throws ServiceException {
        return roleDao.getUserRoleList(userRole);
    }
}
