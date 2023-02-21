package com.coderdianxia.core.enums;

import lombok.Data;

/**
 * @ClassName: ResultContants
 * @Description: 响应结果枚举
 * @Author:coderDianxia
 * @Date: 2022/9/14 14:53
 */

public enum ResultContants{

    SUCCESS(200,"响应成功"),

    FAIL(500,"系统内部错误"),

    VAILD_ERROR(40001,"校验失败"),

    BUSINESS_ERROR(40002,"业务处理失败");

    private int code;

    private String message;

    ResultContants(int code, String message) {
        code = code;
        message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
