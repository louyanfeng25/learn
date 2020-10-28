package com.baiyan.learn.design.structure.adapter;

/**
 * @author baiyan
 * @time 2020/10/26 20:19
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
       //什么也不做
    }
}
