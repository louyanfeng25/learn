package com.baiyan.learn.design.structure.bridge;

/**
 * 桥接模式
 * @author baiyan
 * @time 2020/10/28 14:38
 */
public class Main {

    public static void main(String[] args) {

        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
