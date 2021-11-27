package com.baiyan.learn.math.offer;


/**
 * NC92 最长公共子序列(二)
 *
 * <href>
 *     https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11?tpId=117&&tqId=37798&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/27
 */
public class CaseNc92 {

    public String LCS (String s1, String s2) {
        if(s1==null || s2==null || s1.length()==0 || s2.length()==0){
            return "-1";
        }
        //dp[i][j]表示i长度与j长度的字符串的最长公共子序列的长度
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //相等则+1
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    //不相等时，出现的情况为三种，
                    // i的最后一个字符是多余的，即为i-1的字符与j相等，取dp[i-1][j]
                    // j的最后一个字符是多余的，即为j-1的字符与i相等，取dp[j][i-1]
                    // i跟j最后一个字符都是多余的，因为相等，任取其一
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        if(dp[s1.length()][s2.length()]==0){
            return "-1";
        }
        //开始根据长度进行反推字符串
        int i = s1.length();
        int j = s2.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (i>0 && j>0){
            //如果字符相等则加入字符串
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                stringBuilder.append(s1.charAt(i-1));
                i--;
                j--;
            }else {
                //此处说明i是多余的一个字符，i--
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                    //此处说明i是多余的一个字符，j--
                }else if(dp[i-1][j] < dp[i][j-1]){
                    j--;
                    //此处说明i跟j都是多余的一个字符，i--
                }else {
                    i--;
                    j--;
                }
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        CaseNc92 caseNc92 = new CaseNc92();
        String lcs = caseNc92.LCS("1A2C3D4B56", "B1D23A456A");
        System.out.println(lcs);
    }
}
