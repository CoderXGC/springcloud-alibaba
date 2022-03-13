package com.ylesb;
/**
 * @title: ThreadUnsafeExample
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1310:26
 */

/**
 * @className    : ThreadUnsafeExample
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/13 10:26]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/13 10:26]
 * @updateRemark : [描述说明本次修改内容] 
 */
public class ThreadUnsafeExample {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }
}
