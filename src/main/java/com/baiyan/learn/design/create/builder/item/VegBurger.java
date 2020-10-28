package com.baiyan.learn.design.create.builder.item;

import com.baiyan.learn.design.create.builder.commodity.Burger;

/**
 * @author baiyan
 * @time 2020/10/26 19:54
 */
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
