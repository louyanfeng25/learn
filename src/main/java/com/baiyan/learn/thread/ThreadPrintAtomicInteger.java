package com.baiyan.learn.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread t1 = new Thread(()->{
            while (atomicInteger.get() <=100){
                if(atomicInteger.get() % 3 ==0){
                    System.out.println(Thread.currentThread().getName()+":"+"hello");
                    atomicInteger.getAndIncrement();
                }
            }
        });
        Thread t2 = new Thread(()->{
            while (atomicInteger.get() <=100){
                if(atomicInteger.get() % 3 ==1){
                    System.out.println(Thread.currentThread().getName()+":"+"beautiful");
                    atomicInteger.getAndIncrement();
                }
            }
        });
        Thread t3 = new Thread(()->{
            while (atomicInteger.get() <=100){
                if(atomicInteger.get() % 3 ==2){
                    System.out.println(Thread.currentThread().getName()+":"+"world");
                    atomicInteger.getAndIncrement();
                }
            }
        });
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();

    }
}
