package com.baiyan.learn.design.create.builder.item;

import com.baiyan.learn.design.create.builder.commodity.Burger;

/**
 * @author baiyan
 * @time 2020/10/26 19:54
 */
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
