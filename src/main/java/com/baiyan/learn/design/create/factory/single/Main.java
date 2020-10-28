package com.baiyan.learn.design.create.factory.single;

/**
 * 测试类
 * @author baiyan
 * @time 2020/10/26 19:14
 */
public class Main {

    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();
        catFactory.create().eat();
        TigerFactory tigerFactory = new TigerFactory();
        tigerFactory.create().eat();
        DogFactory dogFactory = new DogFactory();
        dogFactory.create().eat();
    }
}
