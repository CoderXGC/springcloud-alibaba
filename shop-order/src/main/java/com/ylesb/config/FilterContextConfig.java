package com.ylesb.config;
/**
 * @title: FilterConfiguration
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/1216:14
 */

/**
 * @className    : FilterConfiguration
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/12 16:14]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/12 16:14]
 * @updateRemark : [描述说明本次修改内容] 
 */

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FilterContextConfig  {
    /**
     * @NOTE 在spring-cloud-alibaba v2.1.1.RELEASE及前，sentinel1.7.0及后，关闭URL PATH聚合需要通过该方式，spring-cloud-alibaba v2.1.1.RELEASE后，可以通过配置关闭：spring.cloud.sentinel.web-context-unify=false
     * 手动注入Sentinel的过滤器，关闭Sentinel注入CommonFilter实例，修改配置文件中的 spring.cloud.sentinel.filter.enabled=false
     * 入口资源聚合问题：https://github.com/alibaba/Sentinel/issues/1024 或 https://github.com/alibaba/Sentinel/issues/1213
     * 入口资源聚合问题解决：https://github.com/alibaba/Sentinel/pull/1111
     */
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        // 入口资源关闭聚合
        registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
        registration.setName("sentinelFilter");
        registration.setOrder(1);
        return registration;
    }
}