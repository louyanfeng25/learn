package com.baiyan.learn.design.structure.proxy;

import com.baiyan.learn.design.structure.proxy.common.UserService;

/**
 * 静态代理[类似于装饰器做法]
 * @author baiyan
 * @time 2020/10/26 18:37
 */
public class StaticProxy implements UserService {
    private UserService target;

    public StaticProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }

}
