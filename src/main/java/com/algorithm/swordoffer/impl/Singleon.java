package com.algorithm.swordoffer.impl;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/15 15:14
 */
public class Singleon {
    public static void main(String args[]){
        Singleton5 singleton1 = Singleton5.getInstance();
        Singleton5 singleton2 = Singleton5.getInstance();

        System.out.println(singleton1.equals(singleton2));
    }

}

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

/**
 * 懒汉式，非线程安全
 */
class Singleton3{
    private static Singleton3 instance;

    public static Singleton3 getInstance() {
        if (null == instance){
            instance = new Singleton3();
        }
        return instance;
    }

    private Singleton3() {
    }
}

/**
 * 懒汉式，线程安全(给方法加锁)
 */
class Singleton4{
    private static Singleton4 instance;

    public static synchronized Singleton4  getInstance() {
        if (null == instance){
            instance = new Singleton4();
        }
        return instance;
    }

    private Singleton4() {
    }
}

/**
 * 懒汉式，双重检查锁DCL
 */
class Singleton5{
    private static volatile Singleton5 instance;

    public static Singleton5 getInstance(){
        if (null == instance){
            synchronized (Singleton5.class){
                if (null == instance){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
    private Singleton5(){

    }
}

/**
 * 懒汉式，线程安全，静态内部类
 */
class Singleton6{
    private static class SingletonHolder{
        private static Singleton6 instance = new Singleton6();
    }
    public static Singleton6 getInstance(){
        return SingletonHolder.instance;
    }

    private Singleton6() {
    }
}

/**
 * 枚举
 */
enum  Singleton7{
    INSTANCE;
    public void method(){

    }
}



