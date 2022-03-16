package com.ylesb;
/**
 * @title: Bank
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1614:36
 */

import java.util.Objects;

/**
 * @className    : Bank
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/16 14:36]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/16 14:36]
 * @updateRemark : [描述说明本次修改内容] 
 */


public class Bank {
    // 假设一个账户有1000块钱
    static double money = 100;
    // 柜台Counter取钱的方法
    private void Counter(double money) {
        Bank.money -= money;
        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元！");
    }
    // ATM取钱的方法
    private void ATM(double money) {
        Bank.money -= money;
        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    //提供一个对外取款途径，防止直接调取方法同时取款时，并发余额显示错误
    public synchronized void outMoney(double money, String mode) throws Exception{
        if(money > Bank.money){
            //校验余额是否充足
            throw new Exception("取款金额"+money+",余额只剩"+Bank.money+"，取款失败");
        }
        if(Objects.equals(mode, "ATM")){
            ATM(money);
        } else {
            Counter(money);
        }
    }

}