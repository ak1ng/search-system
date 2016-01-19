package com.daimamingong.common.exception;

/**
 * 业务层异常
 *
 * @author robben.qu
 * @since 2015年11月2日 19:33:10
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4332876217497928313L;

	public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
