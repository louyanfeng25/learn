package com.baiyan.learn.design.create.builder.meal;

import com.baiyan.learn.design.create.builder.item.ChickenBurger;
import com.baiyan.learn.design.create.builder.item.Coke;
import com.baiyan.learn.design.create.builder.item.Pepsi;
import com.baiyan.learn.design.create.builder.item.VegBurger;

/**
 * @author baiyan
 * @time 2020/10/26 19:57
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
