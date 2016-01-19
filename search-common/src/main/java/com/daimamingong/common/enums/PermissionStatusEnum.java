package com.daimamingong.common.enums;

/**
 * Ȩ��״̬ö��
 */
public enum PermissionStatusEnum {

    /**
     * ����
     */
    ENABLE(1),

    /**
     * ������
     */
    DISABLE(0);

    private Integer value;

    private PermissionStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }
}
