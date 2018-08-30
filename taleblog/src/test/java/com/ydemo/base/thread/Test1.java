package com.ydemo.base.thread;

/**
 * 生产者和消费者，wait()和notify()的实现
 *
 * @date 2017年6月22日
 */
public class Test1 {
    public  Integer count;
    public   String LOCK;

    public Test1(Integer count, String LOCK) {
        this.count = count;
        this.LOCK = LOCK;
    }

    public static void main(String[] args) {
        Test1 test1=new Test1(0,"lock");
        new Thread(new Producer(test1)).start();
        new Thread(new Consumer(test1)).start();
//        new Thread(new Producer(test1)).start();
//        new Thread(new Consumer(test1)).start();
//        new Thread(new Producer(test1)).start();
//        new Thread(new Consumer(test1)).start();
//        new Thread(new Producer(test1)).start();
//        new Thread(new Consumer(test1)).start();
    }


}