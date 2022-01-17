package com.ylesb.service.Impl;
/**
 * @title: OrderServiceImpl4Listener
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1317:05
 */

import com.ylesb.dao.TxLogDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.TxLog;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @className    : OrderServiceImpl4Listener
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 17:05]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 17:05]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
@RocketMQTransactionListener(txProducerGroup = "tx_producer_group")
public class OrderServiceImpl4Listener implements RocketMQLocalTransactionListener {
    @Autowired
    private OrderServiceImpl4 orderServiceImpl4;
    @Autowired
    private TxLogDao txLogDao;
   //执行本地事务
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        String txId =(String) message.getHeaders().get("txId");
        try {
            Order order =(Order) o;
            orderServiceImpl4.createOrder( txId,order);
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e) {
            //实行失败回滚rollback
            return RocketMQLocalTransactionState.ROLLBACK;
        }


    }
//用于消息回查
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String txId =(String) message.getHeaders().get("txId");
        TxLog txLog=txLogDao.findById(txId).get();
        if (txLog == null) {
            //执行本地事务成功了
            return RocketMQLocalTransactionState.COMMIT;
        }else{
            return RocketMQLocalTransactionState.ROLLBACK;
        }

    }
}
