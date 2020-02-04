package com.ljmoon.springcloud.common.exception;


/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.exception
 * @ClassName SystemException
 * @Description 自定义系统异常
 * @Date 2020/2/4 17:03
 */
public class SystemException extends RuntimeException {

    private final String errorMsg;

    public SystemException(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public SystemException(Throwable cause, String errorMsg) {
        super(cause);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
