package com.baiyan.learn.design.action.strategy;

/**
 * 策略模式测试类
 * @author baiyan
 * @time 2020/10/26 19:31
 */
public class Main {

    public static void main(String[] args) {
        Animal dog = new Animal(new DogStrategy());
        dog.exec();
        Animal tiger = new Animal(new TigerStrategy());
        tiger.exec();
    }
}
