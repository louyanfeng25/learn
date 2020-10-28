package com.baiyan.learn.design.create.factory.mutil;

import com.baiyan.learn.design.create.factory.model.Cat;
import com.baiyan.learn.design.create.factory.model.Dog;
import com.baiyan.learn.design.create.factory.model.Tiger;

/**
 * @author baiyan
 * @time 2020/10/26 19:16
 */
public class ChinaZoo implements AbstractZoo{
    @Override
    public Tiger createTiger(){
        System.out.println("中国工厂制造");
        return new Tiger();
    }

    @Override
    public Cat createCat(){
        System.out.println("中国工厂制造");
        return new Cat();
    }

    @Override
    public Dog createDog(){
        System.out.println("中国工厂制造");
        return new Dog();
    }

}
