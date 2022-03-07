package com.baiyan.interview.math202202.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * BM54 三数之和
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM54 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            int left = i+1;
            int right = num.length-1;

            //重复项不进行计算
            if(i>0 && num[i] == num[i-1]){
                continue;
            }

            while (left<right){
                if(left>i+1 && num[left] == num[left-1]){
                    left++;
                    continue;
                }
                if(right<num.length-1 && num[right] == num[right+1]){
                    right--;
                    continue;
                }
                int sum = num[i] + num[right]+  num[left];
                if(sum==0){
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(num[i]);
                    result.add(num[left]);
                    result.add(num[right]);
                    results.add(result);
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return results;
    }

}
