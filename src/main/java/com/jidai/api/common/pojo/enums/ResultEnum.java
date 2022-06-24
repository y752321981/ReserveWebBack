package com.jidai.api.common.pojo.enums;

public enum ResultEnum {
    SUCCESS("0000", "成功"),
    NULL_TOKEN("1001", "空的token"),
    ERROR_TOKEN("1002", "无效的token"),
    ACCOUNT_NOT_EXIST("2001", "账户不存在"),
    PASSWORD_ERROR("2002", "密码错误"),
    FAIL("5000","失败");
    private String code;

    private String message;
    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }
}
