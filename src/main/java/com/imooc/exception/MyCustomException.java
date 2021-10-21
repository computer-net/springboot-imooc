package com.imooc.exception;

/**
 * 自定义异常
 * 目的：
 *      统一处理异常信息
 *      便于解耦，可以在拦截器，控制层和业务层使用
 */
public class MyCustomException extends RuntimeException {

    public MyCustomException(String message) {
        super(message);
    }
}
