package com.ylesb.controller;
/**
 * @title: OrderController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/2510:39
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import com.ylesb.service.OrderService;
import com.ylesb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className    : OrderController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/25 10:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/25 10:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    //用户下单接口
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid)  {
        log.info("接收{}号商品下单",pid);
        //获取商品信息
        //模拟调用时间
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Product product=productService.findByPid(pid);
        //创建订单
        Order order=new Order();
        order.setUid(1);
        order.setPid(pid);
        order.setUname("xgc");
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
      //  orderService.createOrder(order);
        log.info("下单{}号成功！",pid);
        return order;
    }
    //测试高并发
    @RequestMapping("/order/message")
    private String message(){

       return  orderService.message();
    }
    //测试高并发
    @RequestMapping("/order/message1")
    private String message1(){

       return  orderService.message()+"1";
    }
    /*此段代码有bug，结合文章看看是哪里的问题吧*/
    @RequestMapping("/order/message2")
    @SentinelResource(value ="getNameAndAge")
    private String message2(String name ,Integer age){
        return  "姓名："+name+"年龄："+age;
    }

}
