package com.baiyan.learn.design.structure.bridge;

/**
 * @author baiyan
 * @time 2020/10/28 14:37
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
