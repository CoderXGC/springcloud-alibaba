package com.ylesb.predicates;
/**
 * @title: AgeRoutePredicateFactory
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/2215:57
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @className    : AgeRoutePredicateFactory
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/22 15:57]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/22 15:57]
 * @updateRemark : [描述说明本次修改内容] 
 */

@Component
//这个配置gateway自定义；路由断言工厂前面必须- Age（可以自定义）+RoutePredicateFactory通过年龄自定义断言
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {

    //构造函数
    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }
    //读取配置文件参数，复制到配置类中
    @Override
    public List<String> shortcutFieldOrder() {
        //顺序必须和配置一样
        return Arrays.asList("minAge","maxAge");
    }

    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            /**
             * Evaluates this predicate on the given argument.
             *
             * @param serverWebExchange the input argument
             * @return {@code true} if the input argument matches the predicate,
             * otherwise {@code false}
             */
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {

                //接收配置参数
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                //先判断是否为空
                if (StringUtils.isNotEmpty(ageStr)) {
                    int age = Integer.parseInt(ageStr);
                    if (age < config.getMaxAge() && age > config.getMinAge()) {
                        return true;
                    } else {
                        return false;
                    }
                }
                //在进行逻辑判断
                return false;
            }
        };
    }

    //配置类用于接收配置文件对应参数
    @Data
    //无参构造
    @NoArgsConstructor
    public static class Config {
        private int minAge;
        private int maxAge;
    }
}
