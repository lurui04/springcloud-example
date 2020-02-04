package com.ljmoon.springcloud.common.response;


/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.response
 * @ClassName RspUtil
 * @Description 统一响应构造器
 * @Date 2020/2/4 17:06
 */
public class RspUtil {
    private static final int SUCCESS_CODE = 2000;
    private static final String SUCCESS_MSG = "操作成功";

    private RspUtil() {
    }


    /**
     * 构造成功的响应体，不带返回数据
     *
     * @param
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname success
     * @author lurui
     * @date 2020/2/4 17:07
     */
    public static <T> ResponseResult success() {
        return new ResponseResult<T>(SUCCESS_CODE, SUCCESS_MSG);
    }


    /**
     * 构造成功的响应体，带返回数据
     *
     * @param data
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname success
     * @author lurui
     * @date 2020/2/4 17:08
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult<T>(SUCCESS_CODE, SUCCESS_MSG, data);
    }


    /**
     * 构造失败的响应体
     *
     * @param errorCode
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname fail
     * @author lurui
     * @date 2020/2/4 17:08
     */
    public static <T> ResponseResult fail(IErrorEnum errorCode) {
        return new ResponseResult<T>(errorCode.getErrorCode(), errorCode.getErrorMsg());
    }


    /**
     * 构造异常响应体
     *
     * @param errorCode
     * @param errorMsg
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname fail
     * @author lurui
     * @date 2020/2/4 17:09
     */
    public static <T> ResponseResult fail(int errorCode, String errorMsg) {
        return new ResponseResult<T>(errorCode, errorMsg);
    }

}
