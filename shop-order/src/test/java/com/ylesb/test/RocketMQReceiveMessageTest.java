package com.ylesb.test;
/**
 * @title: RocketMQReceiveMessageTest
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1314:36
 */

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @className    : RocketMQReceiveMessageTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 14:36]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 14:36]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class RocketMQReceiveMessageTest {
    public static void main(String[] args) throws Exception{
        //创建消费者并且指定消费者组的名称
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("myconsumer-group");
        //为消费者设置nameserver地址
        defaultMQPushConsumer.setNamesrvAddr("192.168.109.131.9876");
        //指定消费者订阅的主题和标签
        defaultMQPushConsumer.subscribe("myTopic","*");
        //设置回调函数，设置接收消息的处理方法
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            //处理获取的消息
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                //返回消费成功状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
    }
}
