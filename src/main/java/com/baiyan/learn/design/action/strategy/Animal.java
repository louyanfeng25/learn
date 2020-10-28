package com.baiyan.learn.design.action.strategy;

/**
 * @author baiyan
 * @time 2020/10/26 19:30
 */
public class Animal {
    private Strategy strategy;

    public Animal(Strategy strategy){
        this.strategy = strategy;
    }

    public void exec(){
        this.strategy.eat();
    }

}
