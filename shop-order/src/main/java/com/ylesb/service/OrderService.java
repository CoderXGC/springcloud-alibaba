package com.ylesb.service;
/**
 * @title: OrderService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/2510:38
 */

import com.ylesb.domain.Order;

/**
 * @className    : OrderService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/25 10:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/25 10:38]
 * @updateRemark : [描述说明本次修改内容] 
 */
public interface OrderService {
    void createOrder(Order order);
    String message();
}

