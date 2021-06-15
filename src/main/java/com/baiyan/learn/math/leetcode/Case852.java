package com.baiyan.learn.math.leetcode;

/**
 *
 * 852. 山脉数组的峰顶索引
 *
 * @author baiyan
 * @time 2021/6/15 10:55
 */
public class Case852 {

    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if(j==arr.length-1 || arr[j]<arr[j+1]){
                i = j+1;
                continue;
            }else {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Case852 case852 = new Case852();
        System.out.println(case852.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
