package com.ylesb.filters;
/**
 * @title: LogGatewayFilterFactory
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/2314:16
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @className    : LogGatewayFilterFactory
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/23 14:16]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/23 14:16]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Component
public class LogGatewayFilterFactory  extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {
    //构造函数
    public LogGatewayFilterFactory(){
        super(LogGatewayFilterFactory.Config.class);
    }
    //读取配置文件中的参数 赋值带配置类中
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog","cacheLog");
    }
    //过滤器配置
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (config.isCacheLog()) {
                    //缓存日志开启
                }
                if (config.isConsoleLog()) {
                    //控制台日志开启
                }

                return chain.filter(exchange);
            }
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config{
        private boolean consoleLog;
        private boolean cacheLog;

    }
}
