package com.ljmoon.springcloud.common.exception;


import com.ljmoon.springcloud.common.response.IErrorEnum;

/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.exception
 * @ClassName BusinessException
 * @Description 业务异常
 * @Date 2020/2/4 16:38
 */
public class BusinessException extends RuntimeException {
    private final int errorCode;

    private final String errorMsg;

    public BusinessException(IErrorEnum errorEnum) {
        super(errorEnum.getErrorMsg());
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
    }

    public BusinessException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
