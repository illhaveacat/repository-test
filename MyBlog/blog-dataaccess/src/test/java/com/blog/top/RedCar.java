package com.blog.top;

public class RedCar extends Car {

    public RedCar() {
        this("gfafa");
        System.out.println("子类无参构造函数");
    }

    public RedCar(String s) {
        System.out.println("子类带参构造函数");
    }

    public void testMethod(){
        System.out.println("hhhhhhhhhhh");
    }

}
