package com.baiyan.learn.design.action.strategy;

/**
 * 策略接口
 * @author baiyan
 * @time 2020/10/26 19:28
 */
public class TigerStrategy implements Strategy {

     @Override
     public void eat(){
          System.out.println("老虎吃饭");
     }
}
