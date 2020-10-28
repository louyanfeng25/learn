package com.baiyan.learn.design.create.prototype;

/**
 * @author baiyan
 * @time 2020/10/26 20:02
 */
public class Circle extends Shape{

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
