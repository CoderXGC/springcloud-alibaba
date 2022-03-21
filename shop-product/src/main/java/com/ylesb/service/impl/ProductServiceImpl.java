package com.ylesb.service.impl;
/**
 * @title: ProductImpl
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/229:09
 */

import com.ylesb.dao.ProductDao;
import com.ylesb.domain.Product;
import com.ylesb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className    : ProductImpl
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/22 9:09]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/22 9:09]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByPid(Integer pid) {
        //jpa提供的具体查询功能不需要自行编辑
        return productDao.findById(pid).get();
    }

    @Override
    public void reduceStock(Integer pid, Integer number) {
        Product product = productDao.findById(pid).get();
        //省略库存校验
        //内存中扣减库存
        //模拟异常
        int i=1/0;
        product.setStock(product.getStock() - number);
        productDao.save(product);
    }
}
