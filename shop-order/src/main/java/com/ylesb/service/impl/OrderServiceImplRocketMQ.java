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
import com.ylesb.dao.OrderDao;
import com.ylesb.dao.TxLogDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.TxLog;
import com.ylesb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

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
public class OrderServiceImplRocketMQ  {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private TxLogDao txLogDao;
    //发送半事务消息
    public void createOrderBefore(Order order) {
        String txId= UUID.randomUUID().toString();
        rocketMQTemplate.sendMessageInTransaction("tx_producer_group", "tx_topic", MessageBuilder.withPayload(order).setHeader("txId",txId).build(), order);
    }
    @Transactional
    public void createOrder(String txId,Order order) {
        orderDao.save(order);
        TxLog txLog = new TxLog();
        txLog.setTxId(txId);
        txLog.setDate(new Date());
        //记录事务日志
        txLogDao.save(txLog);
    }
}
