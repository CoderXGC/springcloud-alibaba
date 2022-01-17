package com.ylesb.controller;
/**
 * @title: UserController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:38
 */

import com.ylesb.domain.Product;
import com.ylesb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className    : UserController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:38]
 * @updateRemark : [描述说明本次修改内容] 
 */

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid){
        Product product =productService.findByPid(pid);

        return product;
    }

}
