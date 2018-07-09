package com.all.win.business.common;

/**
 * @Description:
 * @Author: fakerCoder
 * @Date: 2018/7/6 10:59
 * @Version: 1.0.0
 */
public class NoPermissions extends Exception{

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
