package com.ylesb.test;
/**
 * @title: testRocketMQSendMessageTest
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1314:24
 */

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @className    : testRocketMQSendMessageTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 14:24]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 14:24]
 * @updateRemark : [描述说明本次修改内容] 
 */
//RocketMQ消息队列
public class RocketMQSendMessageTest {
    public static void main(String[] args) throws Exception{
        //常见消息生产者，并设置生产者组名
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("myproducer-group");
        //为生产者nameserver
        defaultMQProducer.setNamesrvAddr("192.168.109.131：9876");
        //启动生产者
        defaultMQProducer.start();
        //构建消息对象，主要是设置消息的主题标签内容
        Message message=new Message("myTopic","myTag",("Test RocketMQ ,Message").getBytes());
        //发送消息
        SendResult send=defaultMQProducer.send(message,1000);
        //关闭生产者
        defaultMQProducer.shutdown();
    }
}
