//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ben.java.gof.creative_mode.builder.v2;

public enum ErrorCodeEnums {
    OK(200, "OK"),
    PARAM_ERROR(201, "传入参数有误"),
    INVOKE_ACCOUNT_DATA_ERROR(301, "获取用户信息出错"),
    DATA_NOT_EXIST(404, "数据不存在"),
    SYSTEM_INTER_ERROR(500, "系统内部错误"),
    NOT_FIX_RULE(501, "不符合投保规则"),
    ERROR(1, "未知异常，请稍后再试"),
    GC_ROLE_IS_EXIST(100001, "角色已经存在"),
    GC_ROLE_IS_NOT_EXIST(100002, "角色不存在"),
    GC_USER_ROLE_IS_NOT_EXIST(100003, "用户信息不存在"),
    PREMIUM_ERROR(200001, "计算保费失败");

    private int code;
    private String msg;

    private ErrorCodeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
