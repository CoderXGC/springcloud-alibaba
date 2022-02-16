package com.ylesb.service.fallback;
/**
 * @title: ProductServiceFallback
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/2/169:54
 */

import com.ylesb.domain.Product;
import com.ylesb.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @className    : ProductServiceFallback
 * @description  : [容错逻辑，远程调用异常进入到此类]
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/2/16 9:54]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/2/16 9:54]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class ProductServiceFallback implements ProductService {
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        product.setPname("出现异常进入容错逻辑");
        return product;
    }
}