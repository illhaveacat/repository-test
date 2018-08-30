package com.ydemo.base.thread;

public class Producer implements Runnable {

    private Test1 test1;

    public Producer(Test1 test1) {
        this.test1=test1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (test1) {
                while (test1.count == 10) {
                    try {
                        test1.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                test1.count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + test1.count);
                test1.notifyAll();
            }
        }
    }
}