package com.whh.spring.boot.system.exception;

import java.text.MessageFormat;

/**
 * 自定义异常
 *
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
public class ServiceException extends Exception{
    private int code;

    public ServiceException() {
        super();
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(int code, String message, Object... params) {
        super(MessageFormat.format(message, params));
        this.code = code;
    }

    public ServiceException(int code, String message, Throwable cause, Object... params) {
        super(MessageFormat.format(message, params), cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
