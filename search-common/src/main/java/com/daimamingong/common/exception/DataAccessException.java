package com.daimamingong.common.exception;

/**
 * 数据层异常
 *
 * @author robben.qu
 * @since 2015年11月2日 19:33:20
 */
public class DataAccessException extends RuntimeException {

    private static final long serialVersionUID = -3374644518822132950L;

    public DataAccessException() {
        super();
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    protected DataAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
