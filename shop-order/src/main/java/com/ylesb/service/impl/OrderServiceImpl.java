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
import com.ylesb.service.OrderService;
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
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }
    @Override
    @SentinelResource("messsage")
    public String message() {
        return "message";
    }

    @Override
    @SentinelResource(value ="messsage1",
          //  blockHandlerClass = 自定义类中的方法
            blockHandler="blockHandler",
          //  fallbackClass =
            fallback = "fallback"
    )
    public String message1(String name) {
        return "message";
    }
    //参数需要与message1的参数一致
    public String blockHandler(String name, BlockException e){
    //自定义异常处理逻辑
    log.info("BlockedException进入自定义处理异常逻辑,异常为{}",e);
    return "BlockedException触发定义异常";
    }
    //参数需要与message1的参数一致
    public String fallback(String name, Throwable e){
        //自定义异常处理逻辑
        log.info("Throwable进入自定义处理异常逻辑,异常为{}",e);
        return "Throwable触发定义异常";
    }
}
