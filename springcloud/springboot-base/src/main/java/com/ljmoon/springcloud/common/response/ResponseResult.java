package com.ljmoon.springcloud.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.response
 * @ClassName ResponseResult
 * @Description 信息返回类
 * @Date 2020/2/4 17:10
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {
    /**
     * 响应码
     */
    private int rspCode;
    /**
     * 响应描述
     */
    private String rspDesc;
    /**
     * 响应数据
     */
    private T info;

    public int getRspCode() {
        return rspCode;
    }

    public void setRspCode(int rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspDesc() {
        return rspDesc;
    }

    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public ResponseResult(int rspCode, String rspDesc) {
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
    }

    public ResponseResult(int rspCode, String rspDesc, T info) {
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
        this.info = info;
    }
}
