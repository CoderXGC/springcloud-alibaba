package com.ylesb.controller;
/**
 * @title: NacosConfigController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/149:42
 */

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
 * @createTime   : [2022/1/14 9:42]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/14 9:42]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
//动态刷新配置文件注解
@RefreshScope
public class NacosConfigController {
    @Autowired
    private ConfigurableApplicationContext context;
    @Value("${config.appName}")
    private String appName;
    @RequestMapping("/test-config1")
    public String testConfig1()
    {
        return context.getEnvironment().getProperty("config.appName");
    }
    @RequestMapping("/test-config2")
    public String testConfig2()
    {
        return appName;
    }
}
