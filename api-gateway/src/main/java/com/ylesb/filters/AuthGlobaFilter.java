package com.ylesb.filters;
/**
 * @title: AuthGlobaFilter
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/2314:27
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @className    : AuthGlobaFilter
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/23 14:27]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/23 14:27]
 * @updateRemark : [描述说明本次修改内容] 
 */

@Component
public class AuthGlobaFilter implements GlobalFilter, Ordered {
    //统一鉴权
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token=exchange.getRequest().getQueryParams().getFirst("token");
        if(StringUtils.equals("admin",token))
        {
            //鉴权失败
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        //放行逻辑
        return chain.filter(exchange);
    }
    //标识当前过滤器的优先级，返回值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}