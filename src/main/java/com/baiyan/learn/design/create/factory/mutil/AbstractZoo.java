package com.baiyan.learn.design.create.factory.mutil;

import com.baiyan.learn.design.create.factory.model.Cat;
import com.baiyan.learn.design.create.factory.model.Dog;
import com.baiyan.learn.design.create.factory.model.Tiger;

/**
 * 抽象动物园
 * @author baiyan
 * @time 2020/10/26 19:16
 */
public interface AbstractZoo {

    Tiger createTiger();

    Cat createCat();

    Dog createDog();
}
