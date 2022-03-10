package com.ylesb;
/**
 * @title: RocketMQSendMessageTest
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1016:24
 */

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @className    : RocketMQSendMessageTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/10 16:24]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/10 16:24]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class RocketMQSendMessageTest {
    //发送消息
    public static void main(String[] arg) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //1.创建消息生产者,指定生产者所属的组名
        DefaultMQProducer producer=new DefaultMQProducer("myproducer-group");
      //  2.指定Nameserver地址
       // producer.setNamesrvAddr("150.158.31.224:9876");
        producer.setNamesrvAddr("122.9.161.37:9876");
       // 3.启动生产者
        producer.start();
      //  4.创建消息对象，指定主题、标签和消息体
        Message message=new Message("myTopic","myTag",("Test RocketMQ Message").getBytes());
       // 5.发送消息
        SendResult result=producer.send(message,100000);
        System.out.println(result);
        //6.关闭生产者
        producer.shutdown();
    }
}
