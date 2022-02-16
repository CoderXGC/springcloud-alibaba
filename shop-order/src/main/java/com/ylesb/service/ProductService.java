package com.ylesb.service;
/**
 * @title: ProductService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/289:45
 */

import com.ylesb.domain.Product;
import com.ylesb.service.fallback.ProductServiceFallback;
import com.ylesb.service.fallback.ProductServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className    : ProductService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/28 9:45]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/28 9:45]
 * @updateRemark : [描述说明本次修改内容] 
 */
//value用于指定微服务名称即url
@FeignClient(
        value="service-product",
       //fallback= ProductServiceFallback.class,
       fallbackFactory= ProductServiceFallbackFactory.class
)
public interface ProductService {
    //指定请求的路径
    @RequestMapping("/product/{pid}")
    public Product findByPid(@PathVariable Integer pid);

}

