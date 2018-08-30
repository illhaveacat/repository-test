package com.ydemo.base.thread;

public class Consumer implements Runnable {

    private Test1 test1;

    public Consumer(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (test1) {
                while (test1.count == 0) {
                    try {
                        test1.wait();
                    } catch (Exception e) {
                    }
                }
                test1.count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + test1.count);
                test1.notifyAll();
            }
        }
    }
}