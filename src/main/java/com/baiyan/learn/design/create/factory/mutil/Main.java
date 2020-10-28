package com.baiyan.learn.design.create.factory.mutil;

/**
 * @author baiyan
 * @time 2020/10/26 19:19
 */
public class Main {
    public static void main(String[] args) {
        ChinaZoo chinaZoo = new ChinaZoo();
        chinaZoo.createCat().eat();
        chinaZoo.createDog().eat();
        chinaZoo.createTiger().eat();
        System.out.println("============");
        JapanZoo japanZoo = new JapanZoo();
        japanZoo.createCat().eat();
        japanZoo.createDog().eat();
        japanZoo.createTiger().eat();
    }
}
