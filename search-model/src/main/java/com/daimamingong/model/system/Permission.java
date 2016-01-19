package com.daimamingong.model.system;

import com.daimamingong.model.Base;

/**
 * 权限实体
 *
 * @author robben.qu
 */
public class Permission extends Base<Permission> {

    private static final long serialVersionUID = 1233291425107089665L;

    /**
     * 主键
     */
    private Long permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String permissionDesc;

    /**
     * 是否是菜单
     */
    private String isMenu;

    /**
     * 权限访问地址
     */
    private String permissionUrl;

    /**
     * 权限访问地址
     */
    private String permissionIcon;

    /**
     * 权限等级
     */
    private Integer permissionLevel;

    /**
     * 权限访问地址
     */
    private String permissionKey;

    /**
     * 上级权限编号
     */
    private Long permissionParentId;

    /**
     * 是否启用
     */
    private Integer permissionEnable;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getPermissionIcon() {
        return permissionIcon;
    }

    public void setPermissionIcon(String permissionIcon) {
        this.permissionIcon = permissionIcon;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public Long getPermissionParentId() {
        return permissionParentId;
    }

    public void setPermissionParentId(Long permissionParentId) {
        this.permissionParentId = permissionParentId;
    }

    public Integer getPermissionEnable() {
        return permissionEnable;
    }

    public void setPermissionEnable(Integer permissionEnable) {
        this.permissionEnable = permissionEnable;
    }
}
