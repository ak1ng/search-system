package com.daimamingong.common.enums;

/**
 * 角色状态枚举
 *
 * @author robben.qu
 */
public enum RoleStatusEnum {

    /**
     * 禁用
     */
    DISABLED(0),

    /**
     * 可用
     */
    ENABLE(1);

    private Integer nCode;

    private RoleStatusEnum(Integer _nCode) {
        this.nCode = _nCode;
    }

    public Integer value() {
        return this.nCode;
    }
}
