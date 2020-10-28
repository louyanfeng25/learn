package com.baiyan.learn.design.structure.proxy;

import com.baiyan.learn.design.structure.proxy.common.UserService;
import com.baiyan.learn.design.structure.proxy.common.UserServiceImpl;

/**
 * 测试类
 * @author baiyan
 * @time 2020/10/26 18:43
 */
public class Main {

    /**
     * 静态代理测试
     */
    public void testStaticProxy(){
        UserService userService = new UserServiceImpl();
        StaticProxy proxy = new StaticProxy(userService);
        proxy.save();
    }

    /**
     * 动态代理测试
     */
    public void testDynamicProxy(){
        UserService target = new UserServiceImpl();
        System.out.println(target.getClass());
        UserService proxy = (UserService) new DynamicProxy(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }

    /**
     * cglib代理
     */
    public void testCglibProxy(){
        UserService target = new UserServiceImpl();
        System.out.println(target.getClass());
        UserService proxy = (UserService) new CglibProxy(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.testStaticProxy();
        System.out.println("==============");
        main.testDynamicProxy();
        System.out.println("==============");
        main.testCglibProxy();
    }
}
