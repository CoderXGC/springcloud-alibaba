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
import com.ylesb.dao.TxLogDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.TxLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
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
//和之前的消费者组一样
@RocketMQTransactionListener(txProducerGroup = "tx_producer_group")
public class OrderServiceImplRocketMQListenter implements RocketMQLocalTransactionListener {
    @Autowired
    private OrderServiceImplRocketMQ orderServiceImplRocketMQ;
    @Autowired
    private TxLogDao txLogDao;
    //执行本地事务
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        String txId = (String)message.getHeaders().get("txId");
        try {
            Order order=(Order) arg;
            orderServiceImplRocketMQ.createOrder(txId,order);
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
    //消息回查
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String txId = (String)message.getHeaders().get("txId");
        TxLog txLog = txLogDao.findById(txId).get();
        if(txLog != null){
            //本地事务成功
            return RocketMQLocalTransactionState.COMMIT;
        }else{

        }
        return null;
    }
}
