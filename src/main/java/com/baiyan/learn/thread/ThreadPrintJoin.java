package com.baiyan.learn.thread;

public class ThreadPrintJoin implements Runnable {

    public static int i = 1;

    @Override
    public void run(){
        while (i<=100){
            synchronized (this){
                try {
                    notify();
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    i++;
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ThreadPrintJoin threadPrintJoin = new ThreadPrintJoin();
        Thread t1 = new Thread(threadPrintJoin);
        Thread t2 = new Thread(threadPrintJoin);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
