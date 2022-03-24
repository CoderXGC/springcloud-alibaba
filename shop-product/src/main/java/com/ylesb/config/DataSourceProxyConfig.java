//package com.ylesb.config;
///**
// * @title: DataSourceProxyConfig
// * @projectName springcloud-alibaba
// * @description: TODO
// * @author White
// * @site : [www.ylesb.com]
// * @date 2022/3/2221:25
// */
//
//import com.alibaba.druid.pool.DruidDataSource;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
///**
// * @className    : DataSourceProxyConfig
// * @description  : [描述说明该类的功能]
// * @author       : [XuGuangchao]
// * @site         : [www.ylesb.com]
// * @version      : [v1.0]
// * @createTime   : [2022/3/22 21:25]
// * @updateUser   : [XuGuangchao]
// * @updateTime   : [2022/3/22 21:25]
// * @updateRemark : [描述说明本次修改内容]
// */
//@Configuration
//public class DataSourceProxyConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//    @Primary
//    @Bean
//    public DataSourceProxy datasource (DruidDataSource druidDataSource){
//        return new DataSourceProxy(druidDataSource);
//    }
//}