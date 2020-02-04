package com.ljmoon.springcloud.session.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lurui
 * @Package com.ljmoon.springcloud.session
 * @ClassName SessionUserDO
 * @Description
 * @Date 2020/2/4 21:40
 */
@Data
@AllArgsConstructor
@ToString
public class SessionUserDO {
    private String userId;

    private String userName;

    private String province;

    private String city;

    private Date registTime;

    private Date updateTime;
}
