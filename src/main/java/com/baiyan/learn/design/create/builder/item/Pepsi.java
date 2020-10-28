package com.baiyan.learn.design.create.builder.item;

import com.baiyan.learn.design.create.builder.commodity.ColdDrink;

/**
 * @author baiyan
 * @time 2020/10/26 19:55
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
