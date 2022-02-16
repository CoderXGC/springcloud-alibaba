package com.ylesb.service.fallback;
/**
 * @title: ProductServiceFallbackFactory
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/1615:46
 */

import com.ylesb.domain.Product;
import com.ylesb.service.ProductService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @className    : ProductServiceFallbackFactory
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/16 15:46]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/16 15:46]
 * @updateRemark : [描述说明本次修改内容] 
 */
//容错工厂类实现接口传递接口调用哪个接口产生的容错类
@Service
@Slf4j
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable throwable) {
        //匿名内部类
        return new ProductService() {
            @Override
            public Product findByPid(Integer pid) {
                log.error("报错{}",throwable);
                Product product = new Product();
                product.setPid(pid);
                product.setPname("出现异常进入容错逻辑");
                return product;
            }
        };
    }
}
