package com.baiyan.learn.design.create.builder.commodity;

/**
 * @author baiyan
 * @time 2020/10/26 19:49
 */
public interface Food {
    /**
     * 食物名称
     * @return
     */
    String name();

    /**
     * 打包方式
     * @return
     */
    Packing packing();

    /**
     * 价格
     * @return
     */
    float price();

}
