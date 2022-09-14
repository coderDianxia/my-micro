package com.coderdianxia.core.controller;

import com.coderdianxia.core.domain.Result;
import com.coderdianxia.core.enums.ResultContants;
import com.coderdianxia.core.exception.BusinessException;
import com.coderdianxia.core.exception.ValidException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalControllerAdvice
 * @Description:全局异常处理
 * @Author:coderDianxia
 * @Date: 2022/9/14 15:57
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    /**
     * 通用异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handle(Exception ex){
        return Result.fail(ResultContants.FAIL.getMessage()+":"+ex.getClass().getName()+":"+ex.getLocalizedMessage());
    }

    /**
     * 校验异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ValidException.class)
    public Result handle(ValidException ex){
        return Result.fail(ResultContants.VAILD_ERROR.getCode(),"校验失败:"+ex.getLocalizedMessage());
    }

    /**
     * 业务处理失败异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result handle(BusinessException ex){
        return Result.fail(ResultContants.VAILD_ERROR.getCode(),"业务处理失败:"+ex.getLocalizedMessage());
    }
}
