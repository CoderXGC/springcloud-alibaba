package com.ylesb.service.impl;
/**
 * @title: OrderServiceImpl
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/2510:40
 */

import com.ylesb.dao.OrderDao;
import com.ylesb.domain.Order;
import com.ylesb.service.OrderService;
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
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }
}
