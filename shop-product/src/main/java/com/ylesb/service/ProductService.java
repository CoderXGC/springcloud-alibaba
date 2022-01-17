package com.ylesb.service;
/**
 * @title: UserService
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:38
 */

import com.ylesb.domain.Product;

/**
 * @className    : UserService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:38]
 * @updateRemark : [描述说明本次修改内容] 
 */
public interface ProductService {

    Product findByPid(Integer pid);
}

