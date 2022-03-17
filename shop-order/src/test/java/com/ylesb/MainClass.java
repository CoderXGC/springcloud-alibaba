package com.ylesb;
/**
 * @title: MainClass
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/3/1614:34
 */

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.math.ec.ECCurve;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @className    : MainClass
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/3/16 14:34]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/3/16 14:34]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Slf4j
public class MainClass {
    /**
     * java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     * */
    //public static void main(String[] args) {
    //    //实例化站台对象，并为每一个站台取名字
    //    Station station1=new Station("窗口1");
    //    Station station2=new Station("窗口2");
    //    Station station3=new Station("窗口3");
    //    // 让每一个站台对象各自开始工作
    //    station1.start();
    //    station2.start();
    //    station3.start();
    //}

    //public static void main(String[] args) {
    //    Bank bank = new Bank();
    //    // 实例化两个人，传入同一个银行的对象
    //    PersonA a = new PersonA(bank, "Counter");
    //    PersonB b = new PersonB(bank, "ATM");
    //    a.start();
    //    b.start();
    //}
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       //Thread t=new Thread() {
       //    public void run() {
       //        log.info("子线程");
       //    }
       //};
       //t.setName("t1");
       //t.start();
       //log.info("主线程");

       //Runnable r=new Runnable() {
       //    /**
       //     * When an object implementing interface <code>Runnable</code> is used
       //     * to create a thread, starting the thread causes the object's
       //     * <code>run</code> method to be called in that separately executing
       //     * thread.
       //     * <p>
       //     * The general contract of the method <code>run</code> is that it may
       //     * take any action whatsoever.
       //     *
       //     * @see Thread#run()
       //     */
       //    @Override
       //    public void run() {
       //        log.info("子线程");
       //    }
       //};
       //Thread t2=new Thread(r,"t2");
       //t2.start();
       // Runnable r2=()->{log.info("子线程");};

       // FutureTask<String> futureTask=new FutureTask<>(new Callable<String>() {
       //     @Override
       //     public String call() throws Exception {
       //         log.info("running");
       //         Thread.sleep(2000);
       //         return "over";
       //     }
       // });
       // Thread t3=new Thread(futureTask,"t3");
       // t3.start();
       // log.info("{}",futureTask.get());

        //new Thread(() -> {
        //    while (true) {
        //        log.info("running");
        //    }
        //},"t4").start();
        //new Thread(() -> {
        //    while (true) {
        //        log.info("running");
        //    }
        //},"t5").start();


      //  Thread t=new Thread() {
      //      public void run() {
      //          log.info("子线程");
      //      }
      //  };
      //System.out.println(t.getState());
      //  //t.run();
      //  t.start();
      //  System.out.println(t.getState());

        //Thread t=new Thread() {
        //    public void run() {
        //        try {
        //            Thread.sleep(2000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //};
        //t.setName("t1");
        //t.start();
        //log.info("{}",t.getState());
        //Thread.sleep(500);
        //log.info("{}",t.getState());

        Thread t=new Thread() {
            public void run() {
               log.info("enter sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.info("wake up");
                    e.printStackTrace();
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        log.info("interrupt t");
        t.interrupt();
    }

}