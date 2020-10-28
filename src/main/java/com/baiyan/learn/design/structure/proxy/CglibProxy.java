package com.baiyan.learn.design.structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理【基于字节码层面，使用继承方式，无法代理不可继承的类与方法】
 * @author baiyan
 * @time 2020/10/26 18:51
 */
public class CglibProxy implements MethodInterceptor {
    /**
     * 目标对象
     */
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事务");
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }

}
