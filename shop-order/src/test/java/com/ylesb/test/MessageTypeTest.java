package com.ylesb.test;
/**
 * @title: MessageTypeTest
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1315:55
 */

import com.ylesb.OrderApplication;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className    : MessageTypeTest
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 15:55]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 15:55]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class MessageTypeTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    //可靠同步发送 用于重要邮件通知 报名短信，营销短信
    @Test
    public void testSyncSend(){
        //:tag 是标签
        SendResult result=rocketMQTemplate.syncSend("test-topic-1:tag","这是一个同步消息",10000);

    }
    //可靠异步发送  用于链路耗时较长，对RT响应时间较为敏感业务场景，例如用户视频上传后转码服务，转码完成后对响应结果推送等。
    @Test
    public void testAsyncSend() {
        //:tag 是标签
        rocketMQTemplate.asyncSend("test-topic-1:tag", "这是一条异步消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                //成功回调
            }

            //异常的回调
            @Override
            public void onException(Throwable throwable) {

            }
        });
    }
        //单向发送  用于不可靠等例如日志收集。
        @Test
        public void testOneSend() {
            //:tag 是标签
            rocketMQTemplate.sendOneWay("test-topic-1:tag", "这是一个单向消息" );
        }
    //单向顺序发送  用于不可靠等例如日志收集。
    @Test
    public void testOneOrderlySend() {
        //:tag 是标签第三个参数是决定消息队列发送到哪个队列上
        rocketMQTemplate.sendOneWayOrderly("test-topic-1:tag", "这是一个单向消息","xx");
    }

    }