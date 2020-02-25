package com.ljmoon.springcloud.session;

import com.ljmoon.springcloud.common.response.ResponseResult;
import com.ljmoon.springcloud.common.response.RspUtil;
import com.ljmoon.springcloud.session.pojo.SessionUserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@Api(value = "1111", tags = "222222")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据用户ID查询用户信息",notes = "SESSION-GET",responseContainer = "List",response = ResponseResult.class)
    public ResponseResult getSession(@RequestParam String userId) {
        logger.info("根据userId获取用户信息，userId为：{}", userId);
        SessionUserDO userDO = new SessionUserDO(userId, "test", "BJ", "BJ", new Date(), new Date());
        return RspUtil.success(userDO);
    }


}
