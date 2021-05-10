package com.baiyan.learn.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author baiyan
 * @time 2021/5/9 21:54
 */
public class QuickSort {

    public static void main(String[] args) {
        int length = 100;
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int i, j, temp;
        if (left > right) {
            return;
        }
        //左边哨兵的索引
        i = left;
        //右边哨兵的索引
        j = right;
        //以最左边的作为基准位
        temp = arr[left];
        while (i < j) {
            //一定要先从右边开始
            //从右向左找一个比基准位小的数
            //当右边的位子所在的数大于等于基准位数时，不符合要求，继续找j--;
            //找到的时候退出循环
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //在开始从左边往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //找到i和j了，如果i<j则交换
            if (i < j) {
                int z;
                z = arr[i];
                arr[i] = arr[j];
                arr[j] = z;
            }
        }
        //此时跳出了while循环，说明i=j，它们在同一位置
        //此时，需要将temp和arr[i]进行交换
        arr[left] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
