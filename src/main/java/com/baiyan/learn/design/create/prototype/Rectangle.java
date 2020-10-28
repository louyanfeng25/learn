package com.baiyan.learn.design.create.prototype;

/**
 * @author baiyan
 * @time 2020/10/26 20:01
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
