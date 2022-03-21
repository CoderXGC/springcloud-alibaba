package com.ylesb.controller;
/**
 * @title: OrderController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/2510:39
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ylesb.dao.OrderDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import com.ylesb.service.OrderService;
import com.ylesb.service.ProductService;
import com.ylesb.service.impl.OrderServiceImpl;
import com.ylesb.service.impl.OrderServiceImplRocketMQ;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className    : OrderController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/25 10:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/25 10:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;
    //用户下单接口
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid)  {
        return orderServiceImpl.createOrder(pid);
    }

}
