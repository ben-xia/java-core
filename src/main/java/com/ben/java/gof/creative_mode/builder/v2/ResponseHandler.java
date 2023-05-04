//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ben.java.gof.creative_mode.builder.v2;

import java.util.Date;

public class ResponseHandler {
    public ResponseHandler() {
    }

    public static ResponseDTO success(Object data) {
        return data instanceof Boolean && Boolean.FALSE.equals(data) ? error(ErrorCodeEnums.SYSTEM_INTER_ERROR) : ResponseDTO.builder().success(true).returnCode(ErrorCodeEnums.OK.getCode()).returnMsg(ErrorCodeEnums.OK.getMsg()).currentTime((new Date()).getTime()).result(data).build();
    }

    public static ResponseDTO error(String message) {
        return error(ErrorCodeEnums.SYSTEM_INTER_ERROR.getCode(), message);
    }

    public static ResponseDTO errorParam(String message) {
        return error(ErrorCodeEnums.PARAM_ERROR.getCode(), message);
    }

    public static ResponseDTO error(int code, String message) {
        return ResponseDTO.builder().success(false).returnCode(code).returnMsg(message).build();
    }

    public static ResponseDTO error(ErrorCodeEnums errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }
}
