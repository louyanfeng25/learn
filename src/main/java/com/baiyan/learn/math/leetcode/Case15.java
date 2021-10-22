package com.baiyan.learn.math.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 *
 * <href>
 *     https://leetcode-cn.com/problems/3sum/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/22
 */
public class Case15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).sorted()
                .boxed()
                .collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < collect.size()-2; i++) {
            //数字大于0，后面的也一定大于0
            if(collect.get(i)>0){
                break;
            }
            //去除重复情况,必须与前一个进行比较
            if(i>0 && Objects.equals(collect.get(i),collect.get(i-1))){
                continue;
            }
            int target = -collect.get(i);
            int left = i+1;
            int right = collect.size()-1;
            while (left < right){
               int sum =  collect.get(left) + collect.get(right);
               if(sum == target){
                   result.add(Arrays.asList(collect.get(i),collect.get(left),collect.get(right)));
                   left++;
                   right--;
                   //找到一对之后，防止后续数据重复，例如[0,0,0,0,0,0,0,0]这种场景
                   while (left < right && Objects.equals(collect.get(left) , collect.get(left - 1)) ) {
                       left++;
                   }
                   while (left < right && Objects.equals(collect.get(right) , collect.get(right + 1)) ) {
                       right--;
                   }
               }else if(sum > target){
                   right --;
               }else{
                   left ++;
               }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Case15 case15 = new Case15();
        List<List<Integer>> lists = case15.threeSum(new int[]{0,0,0,0});
        lists.forEach(System.out::println);
    }
}
