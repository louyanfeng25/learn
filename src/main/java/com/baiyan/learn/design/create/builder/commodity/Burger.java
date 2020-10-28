package com.baiyan.learn.design.create.builder.commodity;

/**
 * @author baiyan
 * @time 2020/10/26 19:52
 */
public abstract class Burger implements Food {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}
