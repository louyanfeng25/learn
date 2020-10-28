package com.baiyan.learn.design.create.factory.single;

import com.baiyan.learn.design.create.factory.model.Animal;

/**
 * 动物工厂
 * @author baiyan
 * @time 2020/10/26 19:09
 */
public interface AnimalFactory {
    /**
     * 生产动物
     * @return
     */
    Animal create();

}
