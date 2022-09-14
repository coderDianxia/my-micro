package com.coderdianxia.core.exception;

/**
 * @ClassName: ValidException
 * @Description:参数校验失败异常
 * @Author:coderDianxia
 * @Date: 2022/9/14 16:16
 */
public class ValidException extends Exception {

    public ValidException(String message) {
        super(message);
    }
}
