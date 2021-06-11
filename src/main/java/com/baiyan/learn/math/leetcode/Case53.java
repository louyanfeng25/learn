package com.baiyan.learn.math.leetcode;

/**
 * 53. 最大子序和
 *
 * <href>
 *      https://leetcode-cn.com/problems/maximum-subarray/
 * </href>
 *
 * @author baiyan
 * @time 2021/6/11 15:21
 */
public class Case53 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int x : nums) {
            //获取第i-1个结尾的数据进行比较，比较i-1数+X大还是单独X大
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

//    /**
//     * 暴力解法
//     *
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        if(nums.length==1){
//            return nums[0];
//        }
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length ; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum = sum+nums[j];
//                maxSum = Math.max(sum,maxSum);
//            }
//        }
//        return maxSum;
//    }

    public static void main(String[] args) {
        Case53 case53 = new Case53();
        System.out.println(case53.maxSubArray(new int[]{1,-2,7,-4,10}));
    }
}
