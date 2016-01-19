package com.daimamingong.interfaces.permission;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.common.enums.PermissionStatusEnum;
import com.daimamingong.common.exception.ServiceException;
import com.daimamingong.dao.PermissionDao;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.system.Permission;
import com.daimamingong.model.system.Role;
import com.daimamingong.service.permission.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限业务层实现
 *
 * @author robben.qu
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionDao permissionDao;

    public Result addPermission(Permission permission) throws ServiceException {
        logger.debug("添加权限");
        if (permissionDao.addPermission(permission) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    public Result deletePermission(Permission permission) {
        logger.debug("删除权限");
        permission.setPermissionEnable(PermissionStatusEnum.DISABLE.value());
        if (permissionDao.updatePermission(permission) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    public Result updatePermission(Permission permission) throws ServiceException {
        logger.debug("修改权限");
        if (permissionDao.updatePermission(permission) > 0)
            return new Result(ResultCode.CODE_SUCCESS);

        return new Result(ResultCode.CODE_FAIL);
    }

    public Result getPermission(Permission permission) throws ServiceException {
        logger.debug("获得权限");
        return new Result(ResultCode.CODE_SUCCESS, permissionDao.getPermission(permission));
    }

    public Result getPermissionList(Permission permission) throws ServiceException {
        logger.debug("获得权限列表");
        List<Permission> permissionList = permissionDao.getPermissionList(permission);
        return new Result(ResultCode.CODE_SUCCESS, permissionList);
    }

    @Override
    public List<Permission> getRolesPermissionList(List<Role> roleList) throws ServiceException {
        return permissionDao.getPermissionListByRoles(roleList);
    }

    @Override
    public Result getMenuList(Long userId) throws ServiceException {
        logger.debug("获得用户菜单列表");
        return new Result(ResultCode.CODE_SUCCESS, permissionDao.getPermissionListByUserId(userId));
    }
}
