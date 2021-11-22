package com.baiyan.learn.math.offer;

import java.util.Objects;

/**
 * NC35 编辑距离(二)
 *
 * <href>
 *     https://www.nowcoder.com/practice/05fed41805ae4394ab6607d0d745c8e4?tpId=117&&tqId=37801&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/22
 */
public class CaseNC35 {
    /**
     * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
     * 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
     *
     * (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
     *
     * (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
     *
     * (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
     *
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        if(Objects.equals(str1,"") && Objects.equals(str2,"")) {
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        //想清楚状态矩阵的定义，下标代表长度！！
        int[][] dp =  new int[len1+1][len2+1];
        //str1所有字符全部删除变成str2
        for(int i=0;i<=len1;i++){
            dp[i][0] = i*dc;
        }
        //空字符串str1全部插入变成str2
        for(int j=0;j<=len2;j++){
            dp[0][j] = j*ic;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                //i,j表示长度，下标比较需要减1
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    //替换
                    int choice1 = dp[i-1][j-1] + rc;
                    //插入
                    int choice2 = dp[i][j-1]+ic;
                    //删除
                    int choice3 = dp[i-1][j]+dc;
                    dp[i][j] = Math.min(choice1,Math.min(choice2,choice3));
                }
            }
        }
        return dp[len1][len2];
    }
}
