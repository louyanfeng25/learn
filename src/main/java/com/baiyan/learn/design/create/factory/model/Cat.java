package com.baiyan.learn.design.create.factory.model;

/**
 * 测试类
 * @author baiyan
 * @time 2020/10/26 19:03
 */
public class Cat implements Animal {
    /**
     * 测试接口
     */
    @Override
    public void eat(){
        System.out.println("猫吃饭！");
    }
}
