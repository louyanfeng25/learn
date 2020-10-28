package com.baiyan.learn.design.create.builder.item;

import com.baiyan.learn.design.create.builder.commodity.ColdDrink;

/**
 * @author baiyan
 * @time 2020/10/26 19:54
 */
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
