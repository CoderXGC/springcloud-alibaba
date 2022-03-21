package com.ylesb.controller;
/**
 * @title: NacosConfigController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/2114:11
 */

import com.alibaba.cloud.nacos.NacosConfigProperties;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className    : NacosConfigController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/21 14:11]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/21 14:11]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@RefreshScope  //开启动态刷新功能
public class NacosConfigController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @Value("${config.appName}")
    private String appName;
    @Value("${config.env}")
    private String env;
    @RequestMapping("/nacosconfig1")
    public String getNacosConfig1() {

        return  applicationContext.getEnvironment().getProperty("config.appName");
    }
    @RequestMapping("/nacosconfig2")
    public String getNacosConfig2() {
        return  appName;
    }
    @RequestMapping("/nacosconfig3")
    public String getNacosConfig3() {
        return  env;
    }
}
