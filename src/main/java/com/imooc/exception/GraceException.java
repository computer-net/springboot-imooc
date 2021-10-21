package com.imooc.exception;

/**
 * 优雅地处理异常
 */
public class GraceException {

    public static void display(String errMsg) {
        throw new MyCustomException(errMsg);
    }

}
