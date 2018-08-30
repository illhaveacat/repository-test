package com.ydemo.base.thread;

public class Man {

    private String name;

    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static void main(String[]args){
        Man man=  new Man("james",23);
        test1(man);
        test2(man);
    }

    public static void test1( Man man){
        man.age=30;
    }

    public static void test2( Man man){
        System.out.println(man.age);
    }
}
