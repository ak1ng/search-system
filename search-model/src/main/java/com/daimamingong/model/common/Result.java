package com.daimamingong.model.common;


import java.io.Serializable;

/**
 * JSON响应实体
 *
 * @author robben.qu
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息描述
     */
    private String msg;

    /**
     * 返回数据集
     */
    private Object data;

    public Result(String code) {
        this(code, null, null);
    }

    public Result(String code, Object data) {
        this(code, data, null);
    }

    public Result(String code, Object data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
