package com.ljmoon.springcloud.session;

import com.ljmoon.springcloud.common.response.ResponseResult;
import com.ljmoon.springcloud.common.response.RspUtil;
import com.ljmoon.springcloud.session.pojo.SessionUserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lurui
 * @Package com.ljmoon.springcloud.session
 * @ClassName SessionController
 * @Description sessionCController
 * @Date 2020/2/4 21:31
 */
@RestController
@RequestMapping(value = "/session")
@Api
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据用户ID查询用户信息", notes = "SESSION-GET")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query", dataType = "String")
    public ResponseResult getSession(@RequestParam String userId) {
        logger.info("根据userId获取用户信息，userId为：{}", userId);
        SessionUserDO userDO = new SessionUserDO(userId, "test", "BJ", "BJ", new Date(), new Date());
        return RspUtil.success(userDO);
    }


}
