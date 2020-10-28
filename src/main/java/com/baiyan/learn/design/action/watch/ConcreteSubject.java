package com.baiyan.learn.design.action.watch;

/**
 * @author baiyan
 * @time 2020/10/26 19:34
 */
public class ConcreteSubject extends Subject {

    private String state;

    public void change(String newState){
        this.state = newState;
        System.out.println("主题状态为：" + state);
        this.notifyObservers(state);
    }

}
