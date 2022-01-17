package com.ylesb.domain;
/**
 * @title: User
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1115:16
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @className    : User
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/11 15:16]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/11 15:16]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Data
@Entity(name = "shop_user")
public class User  {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String username;
    private String password;
    private String telephone;

}
