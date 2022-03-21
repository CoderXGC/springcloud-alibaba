package com.ylesb.controller;
/**
 * @title: ProductController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/229:08
 */

import com.alibaba.fastjson.JSON;
import com.ylesb.domain.Product;
import com.ylesb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className    : ProductController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/22 9:08]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/22 9:08]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    //查询商品信息
    @RequestMapping("/product/{pid}")
    public Product findProduct(@PathVariable("pid") Integer pid)
    {
                log.info("进行商品{}号查询",pid);
                Product product = productService.findByPid(pid);
                log.info("商品信息查询成功:{}", JSON.toJSONString(product));
                return product;

    }
    //减库存
    @RequestMapping("/product/reduceStock")
    public void reduceStock(Integer pid,Integer number)
    {
        productService.reduceStock(pid,number);

    }
}
