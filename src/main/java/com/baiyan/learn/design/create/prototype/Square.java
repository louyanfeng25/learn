package com.baiyan.learn.design.create.prototype;

/**
 * @author baiyan
 * @time 2020/10/26 20:02
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
