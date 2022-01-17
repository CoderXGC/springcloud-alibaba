package com.ylesb.service.fallback;
/**
 * @title: ProductServiceFallBack
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1216:26
 */

import com.ylesb.domain.Product;
import com.ylesb.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @className    : ProductServiceFallBack
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/12 16:26]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/12 16:26]
 * @updateRemark : [描述说明本次修改内容] 
 */
//实现feign容错逻辑
@Service
public class ProductServiceFallback implements ProductService{
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPid(pid);
        product.setPname("出现异常进入容错逻辑");
        return product;
    }
}
