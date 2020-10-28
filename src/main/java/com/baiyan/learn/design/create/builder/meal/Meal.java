package com.baiyan.learn.design.create.builder.meal;

import com.baiyan.learn.design.create.builder.commodity.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baiyan
 * @time 2020/10/26 19:56
 */
public class Meal {

    private List<Food> foods = new ArrayList<Food>();

    public void addItem(Food food){
        foods.add(food);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Food food : foods) {
            cost += food.price();
        }
        return cost;
    }

    public void showItems(){
        for (Food food : foods) {
            System.out.print("Item : "+food.name());
            System.out.print(", Packing : "+food.packing().pack());
            System.out.println(", Price : "+food.price());
        }
    }

}
