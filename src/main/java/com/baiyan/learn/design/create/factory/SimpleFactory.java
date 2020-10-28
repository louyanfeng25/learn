package com.baiyan.learn.design.create.factory;

import com.baiyan.learn.design.create.factory.model.Animal;
import com.baiyan.learn.design.create.factory.model.Cat;
import com.baiyan.learn.design.create.factory.model.Dog;
import com.baiyan.learn.design.create.factory.model.Tiger;

/**
 * 静态工厂
 * @author baiyan
 * @time 2020/10/26 19:05
 */
public class SimpleFactory {

    /**
     * 通过类型获取实体
     * @param type 动物种类
     * @return
     */
    public static Animal createInstance(String type){
        if("dog".equals(type)){
            return new Dog();
        }else if("tiger".equals(type)){
            return new Tiger();
        }else if("cat".equals(type)){
            return new Cat();
        }else{
            throw new RuntimeException("type["+type+"]类型不可识别，没有匹配到可实例化的对象！");
        }
    }

    public static void main(String[] args) {
        Animal dog = SimpleFactory.createInstance("dog");
        dog.eat();
        Animal cat = SimpleFactory.createInstance("cat");
        cat.eat();
        Animal tiger = SimpleFactory.createInstance("tiger");
        tiger.eat();
    }

}
