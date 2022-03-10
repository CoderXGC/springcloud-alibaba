package com.ylesb;
/**
 * @title: RocketMQReceiveMessageTest
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1019:38
 */

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @className    : RocketMQReceiveMessageTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/10 19:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/10 19:38]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class RocketMQReceiveMessageTest {
    public static void main(String[] args) throws MQClientException {
       // 1.创建消息消费者,指定消费者所属的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myproducer-group");
       // 2.指定Nameserver地址
        consumer.setNamesrvAddr("122.9.161.37:9876");
       // 3.指定消费者订阅的主题和标签
        consumer.subscribe("myTopic","*");
      //  4.设置回调函数，编写处理消息的方法
        consumer.registerMessageListener(new MessageListenerConcurrently(){
            //获取接收到的消息
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //消费逻辑
                System.out.println("接收到消息："+list);
                //返回消息成功信息。
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
       // 5.启动消息消费者
        consumer.start();
        System.out.println("消费者启动成功了");
    }
}
