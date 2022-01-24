package com.ylesb.service;
/**
 * @title: ProductService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/229:08
 */

import com.ylesb.domain.Product;

/**
 * @className    : ProductService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/22 9:08]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/22 9:08]
 * @updateRemark : [描述说明本次修改内容] 
 */

public interface ProductService {
    //根据pid查商品信息
     Product findByPid(Integer pid);
}
