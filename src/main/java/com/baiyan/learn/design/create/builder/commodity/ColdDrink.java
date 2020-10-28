package com.baiyan.learn.design.create.builder.commodity;

/**
 * @author baiyan
 * @time 2020/10/26 19:53
 */
public abstract class ColdDrink implements Food {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}
