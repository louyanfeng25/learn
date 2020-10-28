package com.baiyan.learn.design.structure.proxy.common;

/**
 * 测试类
 * @author baiyan
 * @time 2020/10/26 18:40
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("保存数据");
    }

}
