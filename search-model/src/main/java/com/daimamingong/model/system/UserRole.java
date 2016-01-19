package com.daimamingong.model.system;

import java.io.Serializable;

/**
 * 角色用户对应实体
 *
 * @author robben.qu
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = 2614068996229048813L;

	/**
     * 主键
     */
    private Long userRoleId;

    /**
     * 角色主键
     */
    private Long roleId;

    /**
     * 用户主键
     */
    private Long userId;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
