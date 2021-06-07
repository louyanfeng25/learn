package com.baiyan.learn.math;

/**
 *
 * 目标和
 *
 * <href>
 *  https://leetcode-cn.com/problems/target-sum/
 * </href>
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * @author baiyan
 * @time 2021/6/7 14:31
 */
public class Case494 {

    int count = 0;

    /**
     * 动态规划
     原问题等同于： 找到nums一个正子集P和一个负子集N，使得总和等于target。即sum(P) - sum(N) == target，
     即sum(P) + sum(N) + sum(P) - sum(N) == target + sum(P) + sum(N)
     即2 * sum(P) == target + sum(nums)， 其中target + sum(nums)必须>=0且为偶数，否则等式不可能成立。
     则问题转换为：存在多少个子集P，使sum(P) == (target + sum(nums))/2。

     dp[i][j]表示前i个元素有多少个目标和为j的子集。dp[0][0] = 1
     1. dp[i][j] = dp[i-1][j]
     2. 如果nums[0...i-2]存在目标和为j-nums[i-1]的子集，则dp[i][j] += dp[i-1][j-nums[i-1]]
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        // 必须>=0且为偶数
        if (target+sum<0 || ((target+sum)&1)==1){
            return 0;
        }
        int neg = (target+sum)/2;
        int[][] dp = new int[nums.length+1][neg+1];
        dp[0][0]=1;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[nums.length][neg];
    }

    /**
     * 回溯法：思路为全局遍历，N个数就有2的N次组合，遍历解决，效率比较低，但是因为数据量不大，可以这么处理
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysBacktrack(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    /**
     * 回溯法求值
     * @param nums
     * @param target
     * @param index
     * @param sum
     */
    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        Case494 case494 = new Case494();
        System.out.println(case494.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

}
