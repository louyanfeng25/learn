package com.baiyan.learn.math;

/**
 * 斐波那契数列
 *
 * <href>
 *     https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * </href>
 *
 * @author baiyan
 * @time 2021/5/9 22:04
 */
public class Fibonacci {

    public static void main(String[] args) {
        //63245986
        System.out.println(Fibonacci.fibonacci1(9));
    }

    /**
     * 求出第n个数递归
     *
     * @param number
     * @return
     */
    public static int fibonacci(int number) {
        if(number<=0){
            return 0;
        }
        if(number<=2){
            return 1;
        }
        return fibonacci(number-1)+fibonacci(number-2);
    }

    /**
     * 求出第n个数迭代
     *
     * @param number
     * @return
     */
    public static int fibonacci1(int number) {
        if(number<=0){
            return 0;
        }
        if(number<=2){
            return 1;
        }
        int first = 1;
        int second = 1;
        int third = 0;
        for(int i=3;i<=number;i++){
            //题目要求的取模
            third = (first + second)%1000000007;
            first = second;
            second = third;
        }
        return third;
    }
}
