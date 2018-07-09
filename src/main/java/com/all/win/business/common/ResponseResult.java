package com.all.win.business.common;

/**
 * @Description: 返回数据的包装类
 * @Author: fakerCoder
 * @Date: 2018/7/6 10:39
 * @Version: 1.0.0
 */
public class ResponseResult {
    private int code;
    private String message;

    private Exception exception;
    public ResponseResult(){
    }
    public ResponseResult(int code,Exception ex){
        this.code= code;
        this.exception = ex;
    }
    public ResponseResult(int code,String message){
        this.code= code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
