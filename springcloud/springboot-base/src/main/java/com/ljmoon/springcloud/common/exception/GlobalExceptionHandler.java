package com.ljmoon.springcloud.common.exception;


import com.ljmoon.springcloud.common.response.ResponseResult;
import com.ljmoon.springcloud.common.response.RspUtil;
import com.ljmoon.springcloud.common.response.errorenum.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.UndeclaredThrowableException;


/**
 * @author lurui
 * @Package com.ljmoon.springcloud.common.exception
 * @ClassName GlobalExceptionHandler
 * @Description 全局统一异常处理
 * @Date 2020/2/4 17:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final int PARAM_ERROR = 101;
    private static final int NOT_FOUND = 404;
    private static final int SERVICE_ERROR = 500;


    /**
     * 自定义业务异常处理
     *
     * @param e
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname businessErrorHandler
     * @author lurui
     * @date 2020/2/4 17:11
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseResult businessErrorHandler(final BusinessException e) {
        logger.warn("异常信息：{}", e);
        return RspUtil.fail(e.getErrorCode(), e.getErrorMsg());
    }


    /**
     * 自定义系统异常处理
     *
     * @param e
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname systemErrorHandler
     * @author lurui
     * @date 2020/2/4 17:12
     */
    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public ResponseResult systemErrorHandler(final SystemException e) {

        logger.error("异常信息：{}", e);
        return RspUtil.fail(SERVICE_ERROR, e.getErrorMsg());
    }


    /**
     * 其他异常全局处理
     *
     * @param e
     * @return com.ljmoon.springcloud.common.response.ResponseResult
     * @methodname defaultErrorHandler
     * @author lurui
     * @date 2020/2/4 17:13
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult defaultErrorHandler(Exception e) {


        if (e instanceof UndeclaredThrowableException) {
            e = (Exception) e.getCause();
        }
        //参数校验失败处理
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            logger.warn("异常信息：{}", e);
            return RspUtil.fail(PARAM_ERROR, exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        }
        if (e instanceof NoHandlerFoundException) {
            logger.warn("异常信息：{}", e);
            return RspUtil.fail(NOT_FOUND, e.getMessage());
        }

        if (e instanceof RuntimeException) {
            logger.error("异常信息：{}", e);
            //运行异常，程序bug，单独记录异常信息，并统一响应：系统运行时异常，请联系管理员
            return RspUtil.fail(ErrorCodeEnum.SYS_API_ERR_100);
        }
        logger.error("异常信息：{}", e);
        //检查异常，直接返回客户端异常信息
        return RspUtil.fail(SERVICE_ERROR, e.toString());

    }
}
