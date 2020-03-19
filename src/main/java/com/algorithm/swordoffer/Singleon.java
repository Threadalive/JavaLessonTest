package com.algorithm.swordoffer;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/15 15:14
 */
public class Singleon {}

/**
 * 饿汉式 浪费资源
 * 静态，加载类时创建完成，全局唯一
 */
class Singleton1{
    private static final Singleton1 instance = new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }
    private Singleton1() {
    }
}

/**
 * 静态创建对象
 */
class Singleton2{
    private static Singleton2 instance;
    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }

    private Singleton2() {
    }
}




