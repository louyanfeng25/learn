package com.baiyan.learn.design.create.single;

/**
 * 懒汉模式
 * @author baiyan
 * @time 2020/10/26 19:22
 */
public class SingletonLazy {

    private volatile static SingletonLazy instance;

    private SingletonLazy (){
    }

    public static SingletonLazy getInstance() {
        if (instance== null) {
            synchronized (SingletonLazy.class) {
                if (instance== null) {
                    instance= new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
