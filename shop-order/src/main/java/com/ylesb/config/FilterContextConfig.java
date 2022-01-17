package com.ylesb.config;
/**
 * @title: FilterContextConfig
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1214:59
 */
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className    : FilterContextConfig
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/12 14:59]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/12 14:59]
 * @updateRemark : [描述说明本次修改内容] 
 */
//import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
//@Configuration
public class FilterContextConfig {
    //@Bean
    //public FilterRegistrationBean sentinelFilterRegistration() {
    //    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    //    registrationBean.setFilter(new CommonFilter());
    //    registrationBean.addUrlPatterns("/*");
    //    // 入口资源关闭聚合
    //    registrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
    //    registrationBean.setName("sentinelFilter");
    //    registrationBean.setOrder(1);
    //    return registrationBean;
    //}
}