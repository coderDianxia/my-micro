package com.coderdianxia.core.exception;

/**
 * @ClassName: BusinessException
 * @Description:业务失败异常
 * @Author:coderDianxia
 * @Date: 2022/9/14 16:23
 */
public class BusinessException extends Exception{

    public BusinessException(String message) {
        super(message);
    }
}
