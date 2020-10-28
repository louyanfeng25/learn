package com.baiyan.learn.design.action.watch;

/**
 * 抽象观察者角色类
 *
 * @author baiyan
 * @time 2020/10/26 19:35
 */
public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    void update(String state);
}
