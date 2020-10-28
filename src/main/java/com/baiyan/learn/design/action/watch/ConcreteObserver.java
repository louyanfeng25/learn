package com.baiyan.learn.design.action.watch;

/**
 * 具体观察者角色类
 * @author baiyan
 * @time 2020/10/26 19:35
 */
public class ConcreteObserver implements Observer{
    /**
     * 观察者的状态
     */
    private String observerState;

    @Override
    public void update(String state) {
        this.observerState = state;
        System.out.println("状态为："+observerState);
    }

}
