package com.baiyan.learn.math.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 *
 * @author baiyan
 * @time 2021/12/8
 */
public class MergeSort {

    public static void main(String[] args) {
        int length = 100;
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int []arr){
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int []temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (right+left)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (j<=right){
            temp[t++] = arr[j++];
        }
        while (i<=mid){
            temp[t++] = arr[i++];
        }
        t=0;
        while (left<=right){
            arr[left++] = temp[t++];
        }

    }
}
