package com.ylesb.domain;
/**
 * @title: TxLog
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/149:34
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @className    : TxLog
 * @description  : [消息事务状态记录表]
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/14 9:34]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/14 9:34]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Data
@Entity(name = "shop_txlog")
public class TxLog {
    @Id
    private String txId;
    private Date date;


}
