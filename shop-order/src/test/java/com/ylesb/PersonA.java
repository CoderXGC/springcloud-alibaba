package com.ylesb;
/**
 * @title: PersonA
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1614:37
 */

/**
 * @className    : PersonA
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/16 14:37]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/16 14:37]
 * @updateRemark : [描述说明本次修改内容] 
 */


public class PersonA extends Thread {

    Bank bank;

    String mode;

    public PersonA(Bank bank, String mode) {
        this.mode = mode;
        this.bank = bank;
    }

    public void run (){
        while(bank.money >= 100){
            try {
                bank.outMoney(100, mode);
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