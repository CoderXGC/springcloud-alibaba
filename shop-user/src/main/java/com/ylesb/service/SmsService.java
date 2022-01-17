package com.ylesb.service;
/**
 * @title: SmsService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1315:39
 */

import com.ylesb.dao.UserDao;
import com.ylesb.domain.Order;
import com.ylesb.domain.User;
import lombok.val;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @className    : SmsService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 15:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 15:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
//消费者组名consumerGroup  topic消费的组名
@RocketMQMessageListener(consumerGroup = "shop-user",//消费者组名
        topic = "order-topic",//消费主题
        consumeMode= ConsumeMode.CONCURRENTLY,//消费模式，是否是定顺序消费CONCURRENTLY同步，orderly顺序
        messageModel = MessageModel.CLUSTERING//消息模式 BROADCASTING(广播)
)
public class SmsService implements RocketMQListener<Order>{
    @Autowired
    UserDao userDao;
    @Override
    public void onMessage(Order order) {
        //接收到了订单信息，就可以发短信了
        //根据uid获取手机号
        User user = userDao.findById(order.getUid()).get();
        //生成验证码
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<6;i++){
            builder.append(new Random().nextInt(9)+1);
        }
     String code=builder.toString();
        //发送短信
    }
}
