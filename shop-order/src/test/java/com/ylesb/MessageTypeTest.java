package com.ylesb;
/**
 * @title: MessageTyoeTest
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1315:38
 */

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className    : MessageTyoeTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/13 15:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/13 15:38]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class MessageTypeTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    //同步消息
    @Test
    public void testSyncSend(){
        //参数一： topic 添加tag 可以使用topic：tag
        //参数二： 消息内容
        SendResult sendResult = rocketMQTemplate.syncSend("test-topic-1:tag","这是一条同步消息");
        System.out.println(sendResult);
    }
    //异步消息
    @Test
    public void testAyncSend() throws InterruptedException{
            //参数一： topic 添加tag 可以使用topic：tag
            //参数二： 消息内容
            //参数三: 回调结果，处理返回结果
         rocketMQTemplate.asyncSend("test-topic-1:tag", "这是一条异步消息", new SendCallback() {
             @Override
             public void onSuccess(SendResult sendResult) {
                 System.out.println(sendResult);
             }

             @Override
             public void onException(Throwable throwable) {
                     System.out.println(throwable);
             }
         });
         System.out.println("=========================");
            Thread.sleep(30000000000L);
    }
    //单向消息
    @Test
    public void testOneWaySend(){
        //参数一： topic 添加tag 可以使用topic：tag
        //参数二： 消息内容
        rocketMQTemplate.sendOneWay("test-topic-1:tag","这是一条单向消息");
    }
    //单向顺序消息
    @Test
    public void sendOneWayOrderly(){
        //参数一： topic 添加tag 可以使用topic：tag
        //参数二： 消息内容
        //参数三： 发送到哪个队列
        rocketMQTemplate.sendOneWayOrderly("test-topic-1:tag","这是一条单向消息","xxx");
    }
    //同步顺序消息
    @Test
    public void testSyncSendOrderly(){
        //参数一： topic 添加tag 可以使用topic：tag
        //参数二： 消息内容
        //参数三： 发送到哪个队列
        rocketMQTemplate.syncSendOrderly("test-topic-1:tag","这是一条单向消息","xxx");
    }
    //异步顺序消息
    @Test
    public void testAyncSendOrderly() throws InterruptedException {
        //参数一： topic 添加tag 可以使用topic：tag
        //参数二： 消息内容
        //参数三: 回调结果，处理返回结果
        rocketMQTemplate.asyncSendOrderly("test-topic-1:tag", 10000, "这是一条异步消息", new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.println(sendResult);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        System.out.println(throwable);
                    }
                });
        System.out.println("=========================");
        Thread.sleep(30000000000L);
    }
}
