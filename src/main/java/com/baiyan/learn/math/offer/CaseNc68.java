package com.baiyan.learn.math.offer;

/**
 * NC68 跳台阶
 *
 * <href>
 *     https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=117&tqId=37764&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117%26page%3D1&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * </href>
 *
 * @author baiyan
 * @time 2022/02/10
 */
public class CaseNc68 {

    public int jumpFloor(int number) {
        if(number<=1){
            return 1;
        }
        if(number==2){
            return 2;
        }
        int[] dp = new int[number+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= number; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[number];
    }

}
