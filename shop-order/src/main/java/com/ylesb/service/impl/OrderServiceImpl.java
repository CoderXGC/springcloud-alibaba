package com.ylesb.service.impl;
/**
 * @title: OrderServiceImpl
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/2510:40
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import com.ylesb.dao.OrderDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import com.ylesb.service.OrderService;
import com.ylesb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className    : OrderServiceImpl
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/25 10:40]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/25 10:40]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
@Slf4j
public class OrderServiceImpl {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderServiceImplRocketMQ orderServiceImplRocketMQ;
    public Order createOrder(Integer pid) {
        Product product = productService.findByPid(pid);
        log.info("接收{}号商品下单",pid);
        //创建订单
        Order order=new Order();
        order.setUid(1);
        order.setPid(pid);
        order.setUname("xgc");
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        log.info("下单{}号成功！",pid);

        //扣库存
        productService.reduceStock(pid,order.getNumber());
        //向mq发消息
        //参数一指定topic
        //参数二指定消息内容
        //rocketMQTemplate.convertAndSend("order-topic",order);
        return order;
    }

}
