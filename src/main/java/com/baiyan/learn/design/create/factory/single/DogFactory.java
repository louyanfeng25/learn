package com.baiyan.learn.design.create.factory.single;

import com.baiyan.learn.design.create.factory.model.Animal;
import com.baiyan.learn.design.create.factory.model.Dog;

/**
 * 狗工厂
 * @author baiyan
 * @time 2020/10/26 19:12
 */
public class DogFactory implements AnimalFactory {

    @Override
    public Animal create(){
        return new Dog();
    }
}
