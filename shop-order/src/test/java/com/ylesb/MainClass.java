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
import org.bouncycastle.jcajce.provider.symmetric.Twofish;
import org.bouncycastle.math.ec.ECCurve;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

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
    static int r=0;
    static int r1=0;
    static int r2=0;
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

        //Thread t=new Thread() {
        //    public void run() {
        //       log.info("enter sleep...");
        //        try {
        //            Thread.sleep(2000);
        //        } catch (InterruptedException e) {
        //            log.info("wake up");
        //            e.printStackTrace();
        //        }
        //    }
        //};
        //t.start();
        //Thread.sleep(1000);
        //log.info("interrupt t");
        //t.interrupt();

        //TimeUnit.SECONDS.sleep(1);//等待1秒可读性更好

        //Runnable task1=()->{
        //    int  count=0;
        //    for(;;){
        //        System.out.println("----->task1:"+count++);
        //    }
        //};
        //Runnable task2=()->{
        //    int  count=0;
        //    for(;;){
        //       // Thread.yield();
        //        System.out.println("     ----->task2:"+count++);
        //    }
        //};
        //Thread t1=new Thread(task1,"t1");
        //Thread t2=new Thread(task2,"t2");
        //t1.setPriority(Thread.MAX_PRIORITY);
        //t2.setPriority(Thread.MIN_PRIORITY);
        //t1.start();
        //t2.start();

        //防止CPU,占用100%
        //while(true){
        //    try {
        //        sleep(50);//让cpu睡眠50ms
        //    }catch (Exception e){
        //        e.printStackTrace();
        //    }
        //}

        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
       // test6();
        //test7();
        test8();
        //TwoPhaseTermination tpt=new TwoPhaseTermination();
        //tpt.start();
        //Thread.sleep(3500);
        //tpt.stop();
    }
    public static void test1() throws InterruptedException {
        log.info("开始");
        Thread t=new Thread(()->{
            log.info("子线程开始");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("子线程结束");
          r=10;
        },"t1");
        t.start();
        t.join();//等待子线程执行完毕
        log.info("结果为：{}",r);
        log.info("结束");

    }
    public static void test2() throws InterruptedException {
        log.info("开始");
        Thread t1=new Thread(()->{
            log.info("t1子线程开始");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t1子线程结束");
            r1=10;
        },"t1");
        Thread t2=new Thread(()->{
            log.info("t2子线程开始");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t2子线程结束");
            r2=20;
        },"t2");
        t1.start();
        t2.start();
        long start=System.currentTimeMillis();
        log.info("join begin");
        t1.join();//等待子线程t1执行完毕
        log.info("t1 join end");
        t2.join();//等待子线程t2执行完毕
        log.info("t2 join end");
        long end=System.currentTimeMillis();
        log.info("r1：{} r2：{} cost：{}",r1,r2,end-start);
        log.info("结束");

    }
    public static void test3() throws InterruptedException {
        log.info("开始");
        Thread t=new Thread(()->{
            log.info("子线程开始");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("子线程结束");
            r1=10;
        },"t1");
        long start=System.currentTimeMillis();
        t.start();
        log.info("join begin");
        t.join(3000);//等待子线程执行完毕
        long end=System.currentTimeMillis();
        log.info("r1：{} r2：{} cost：{}",r1,r2,end-start);
        log.info("结束");

    }
    public static void test4() throws InterruptedException {

        Thread t=new Thread(()->{
            log.info("开始");
            try {
                sleep(5000);//wait join 打断为false
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");

        t.start();
        Thread.sleep(1000);
        log.info("interrupt t");
        t.interrupt();//中断子线程
        log.info("打断标记:{}",t.isInterrupted());

    }
    public static void test5() throws InterruptedException {

        Thread t=new Thread(()->{
            while(true){
                boolean interrupted=Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.info("被打断了，退出循环");
                    break;
                }
            }
        },"t1");

        t.start();
        Thread.sleep(1000);
        log.info("interrupt t");
        t.interrupt();//中断子线程

    }
    public static void test6() throws InterruptedException {

        Thread t=new Thread(()->{
            while(true){
                boolean interrupted=Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.info("被打断了，退出循环");
                    break;
                }
            }
        },"t1");

        t.start();
        Thread.sleep(1000);
        log.info("interrupt t");
        t.interrupt();//中断子线程

    }
    public static void test7() throws InterruptedException {

        Thread t=new Thread(()->{
           log.info("park....");
            LockSupport.park();
            log.info("unpark....");
            log.info("打断标记:{}",Thread.currentThread().isInterrupted());
            LockSupport.park();
        },"t1");

        t.start();
        Thread.sleep(1000);
        log.info("interrupt t");
        t.interrupt();//中断子线程

    }
    public static void test8() throws InterruptedException {

        Thread t=new Thread(()->{
            while(true){
                boolean interrupted=Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.info("被打断了，退出循环");
                    break;
                }
            }
            log.info("结束");
        },"t1");
        t.setDaemon(true);//设置为守护线程 主线程结束，守护子线程也会结束 但是普通子线程不会
        t.start();
        log.info("结束");
    }


}
@Slf4j
class TwoPhaseTermination {
    private Thread monitor;
    public void start() throws InterruptedException {
        monitor=new Thread(()->{
            while(true){
                Thread current=Thread.currentThread();
                if (current.isInterrupted()) {
                    log.info("被打断了，退出循环");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.info("执行监控");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //打断线程
                    current.interrupt();
                }

            }
        });
        monitor.start();
    }
    public void stop() throws InterruptedException {
        monitor.interrupt();
    }
}