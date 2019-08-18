package com.waston.exception;

import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class SysException extends Exception{

    //存储异常信息
    private String msg;

    public SysException(String msg) {
        this.msg = msg;
    }
}
