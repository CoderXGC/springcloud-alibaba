package com.ylesb.domain;
/**
 * @title: TxLog
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/1317:14
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @className    : TxLog
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/13 17:14]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/13 17:14]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Data
@Entity(name = "shop_txlog")
//消息事务状态记录
public class TxLog {
    @Id
    private String txId;
    private Date date;
}
