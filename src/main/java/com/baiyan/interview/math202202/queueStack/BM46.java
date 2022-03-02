package com.baiyan.interview.math202202.queueStack;

import java.util.ArrayList;

/**
 * BM46 最小的K个数
 *
 * @author baiyan
 * @date 2022-03-02
 */
public class BM46 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        quickSort(input,0,input.length-1);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;

    }

    /**
     * 快排
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int i = left;
        int j = right;
        int tmp = arr[left];
        while (i<j){
            while (i<j && arr[j] > tmp){
                j--;
            }
            while (i<j && arr[i] <= tmp){
                i++;
            }
            if(i<j){
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        arr[left] = arr[i];
        arr[i] = tmp;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }
}
