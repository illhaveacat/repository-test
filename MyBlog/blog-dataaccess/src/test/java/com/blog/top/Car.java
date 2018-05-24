package com.blog.top;

public class Car {


    public Car() {
        System.out.println("父类无参构造函数");
        testMethod();
    }

    public Car(String ss) {
        System.out.println("父类带一个参数构造函数");

    }

    public void testMethod(){
        System.out.println("fagagagagag");
    }
}
