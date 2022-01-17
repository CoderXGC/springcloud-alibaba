package com.ylesb.controller;
/**
 * @title: UserController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:38
 */

import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import com.ylesb.service.OrderService;
import com.ylesb.service.ProductService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @className    : UserController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:38]
 * @updateRemark : [描述说明本次修改内容] 
 */

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductService productService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @RequestMapping("/order/prod/{pid}")
    public Order oder(@PathVariable("pid") Integer pid){
        //List<ServiceInstance> instances=discoveryClient.getInstances("service-product");
        //ServiceInstance serviceInstance = instances.get(0);
        //
        //Product product = restTemplate.getForObject("http://service-product/product/"+pid,Product.class);
        Product product = productService.findByPid(pid);
        Order order = new Order();
        order.setUid(1);
        orderService.createOrder(order);
        //参数1指定topic
        //指定消息体
        rocketMQTemplate.convertAndSend("order-topic",order);


        return order;
    }
}
