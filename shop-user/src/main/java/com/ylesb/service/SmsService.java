package com.ylesb.service;
/**
 * @title: SmsService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1116:54
 */

import com.ylesb.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @className    : SmsService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/11 16:54]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/11 16:54]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
@Slf4j
//消费者组名
//topic消费组名
@RocketMQMessageListener(consumerGroup = "shop-user", topic = "order-topic",
     consumeMode = ConsumeMode.CONCURRENTLY ,//消费模式，指定是否为顺序消费 CONCURRENTLY（同步消息）ORDERLY（顺序消息）
         messageModel = MessageModel.BROADCASTING  //消息模式，指定是否为广播消息 BROADCASTING（广播消息）CLUSTERING（集群消息）
)
public class SmsService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        log.info("接收到消息：{}发送短信通知",order);
    }
}
