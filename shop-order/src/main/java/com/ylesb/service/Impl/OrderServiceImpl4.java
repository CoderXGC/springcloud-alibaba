package com.ylesb.service.Impl;
/**
 * @title: OrderServiceImpl4
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1316:59
 */

import com.ylesb.dao.OrderDao;
import com.ylesb.dao.TxLogDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.TxLog;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @className    : OrderServiceImpl4
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 16:59]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 16:59]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class OrderServiceImpl4 {
    @Autowired
    OrderDao orderDao;
    @Autowired
    TxLogDao txLogDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void createOrderBefore(Order order) {
        String txId= UUID.randomUUID().toString();
        //发送半事务消息
        rocketMQTemplate.sendMessageInTransaction("tx_producer_group","tx", MessageBuilder.withPayload(order).
                setHeader("txId",txId).build(), order
        );
    }
    @Transactional
    public void createOrder(String txId,Order order) {
        orderDao.save(order);
        TxLog txLog=new TxLog();
        txLog.setTxId(txId);
        txLog.setDate(new Date());
        txLogDao.save(txLog);
    }

}
