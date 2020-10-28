package com.baiyan.learn.design.create.single;

/**
 * 饿汉模式
 * @author baiyan
 * @time 2020/10/26 19:22
 */
public class SingletonHunger {

    private static SingletonHunger instance = new SingletonHunger();

    private SingletonHunger (){
    }

    public static SingletonHunger getInstance() {
        return instance;
    }
}
