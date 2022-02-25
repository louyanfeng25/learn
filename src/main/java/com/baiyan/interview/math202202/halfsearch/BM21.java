package com.baiyan.interview.math202202.halfsearch;

/**
 * BM21 旋转数组的最小数字
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM21 {

    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if(array[mid] < array[right]){
                right = mid;
            }else if(array[mid] == array[right]){
                right = right-1;
            }else {
                left = mid+1;
            }
        }
        return array[left];
    }

}
