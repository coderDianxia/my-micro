package com.coderdianxia.core.domain;

import com.coderdianxia.core.enums.ResultContants;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @Description:统一返回结果类
 * @Author:coderDianxia
 * @Date: 2022/9/14 14:47
 */
@Data
public class Result<T>  implements Serializable {


    private int code;
    private String msg;
    private T data;

    public static  <T> Result<T> success() {
        return result(ResultContants.SUCCESS.getCode(),ResultContants.SUCCESS.getMessage(),null);
    }

    public static  <T> Result<T> success(String msg) {
        return result(ResultContants.SUCCESS.getCode(),msg,null);
    }

    public static  <T> Result<T> success(T data) {
        return result(ResultContants.SUCCESS.getCode(),ResultContants.SUCCESS.getMessage(),data);
    }

    public static  <T> Result<T> success(T data,String msg) {
        return result(ResultContants.SUCCESS.getCode(),msg,data);
    }

    public static  <T> Result<T> fail() {
        return result(ResultContants.FAIL.getCode(),ResultContants.FAIL.getMessage(),null);
    }

    public static  <T> Result<T> fail(String msg) {
        return result(ResultContants.FAIL.getCode(),msg,null);
    }

    public static  <T> Result<T> fail(int code,String msg) {
        return result(code,msg,null);
    }

    public static  <T> Result<T> fail(T data) {
        return result(ResultContants.FAIL.getCode(),ResultContants.FAIL.getMessage(),data);
    }

    public static  <T> Result<T> fail(T data,String msg) {
        return result(ResultContants.FAIL.getCode(),msg,data);
    }


    private static <T> Result<T> result(int code,String msg,T data){
        Result<T>  result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


}
