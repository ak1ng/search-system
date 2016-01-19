package com.daimamingong.model.system;

import com.daimamingong.model.Base;

import java.util.List;

/**
 * 角色实体类
 *
 * @author robben.qu
 */
public class Role extends Base<Role> {

    private static final long serialVersionUID = -5867265805498721115L;

    /**
     * 主键
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * KEY
     */
    private String roleKey;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 角色状态
     */
    private Integer roleEnable;

    /**
     * 角色权限
     */
    private List<Permission> permissionList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleEnable() {
        return roleEnable;
    }

    public void setRoleEnable(Integer roleEnable) {
        this.roleEnable = roleEnable;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
