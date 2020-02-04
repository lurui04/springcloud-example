package com.ljmoon.springcloud.common.response.errorenum;

import com.ljmoon.springcloud.common.response.IErrorEnum;

/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.response.errorenum
 * @ClassName ErrorCodeEnum
 * @Description 系统异常码枚举
 * @Date 2020/2/4 17:05
 */
public enum ErrorCodeEnum implements IErrorEnum {


    //  API模块错误码
    SYS_API_SUCCESS_2000(2000, "请求成功"),
    SYS_API_ERR_100(100, "系统运行时错误"),
    SYS_API_ERR_2001(2001, "USERID不存在或者无效");

    private int errorCode;
    private String errorMsg;

    ErrorCodeEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static String getErrorMsg(int errorCode) {
        for (ErrorCodeEnum flag : values()) {
            if (flag.getErrorCode() == errorCode) {
                return flag.getErrorMsg();
            }
        }
        return null;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
