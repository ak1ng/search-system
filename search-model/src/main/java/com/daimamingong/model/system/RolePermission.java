package com.daimamingong.model.system;

import java.io.Serializable;

/**
 * 角色权限对应实体
 *
 * @author robben.qu
 */
public class RolePermission implements Serializable {

	private static final long serialVersionUID = 2786392934619313974L;

	/**
     * 主键
     */
    private Long rolePermissionId;

    /**
     * 角色主键
     */
    private Long roleId;

    /**
     * 权限主键
     */
    private Long permissionId;

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
