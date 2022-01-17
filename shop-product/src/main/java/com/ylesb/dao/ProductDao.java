package com.ylesb.dao;
/**
 * @title: UserDao
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:40
 */

import com.ylesb.domain.Product;
import com.ylesb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className    : UserDao
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:40]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:40]
 * @updateRemark : [描述说明本次修改内容] 
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
}

