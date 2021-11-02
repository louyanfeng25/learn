package com.baiyan.learn.math.offer;

/**
 * NC19 连续子数组的最大和
 *
 * <href>
 *     https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=117&&tqId=37797&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/02
 */
public class CaseNC19 {

    /**
     * 动态规划，规则表达式转换，dp[i]表示以array[i]结尾的元素的最大值
     *
     * dp[i] = max(dp[i]+array[i],dp[i])
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==1){
            return array[0];
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }


    public static void main(String[] args) {
        CaseNC19 caseNC19 = new CaseNC19();
        int i = caseNC19.FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(i);
    }
}
