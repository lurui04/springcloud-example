package com.ljmoon.springcloud.common.response;

/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.response
 * @ClassName IErrorEnum
 * @Description 异常枚举接口
 * @Date 2020/2/4 17:05
 */
public interface IErrorEnum {

    int getErrorCode();

    String getErrorMsg();

}
