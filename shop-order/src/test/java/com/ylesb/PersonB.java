package com.ylesb;
/**
 * @title: PersonB
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1614:38
 */

/**
 * @className    : PersonB
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/16 14:38]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/16 14:38]
 * @updateRemark : [描述说明本次修改内容] 
 */


public class PersonB extends Thread {
    Bank bank;

    String mode;

    public PersonB(Bank bank, String mode) {
        this.bank = bank;
        this.mode = mode;
    }

    public void run() {
        while (bank.money >= 200) {
            try {
                bank.outMoney(200, mode);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
