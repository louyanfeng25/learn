package com.baiyan.learn.design.create.builder;

import com.baiyan.learn.design.create.builder.meal.Meal;
import com.baiyan.learn.design.create.builder.meal.MealBuilder;

/**
 * 建造者模式
 * @author baiyan
 * @time 2020/10/26 19:58
 */
public class Main {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }

}
