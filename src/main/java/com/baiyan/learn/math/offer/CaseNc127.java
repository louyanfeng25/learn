package com.baiyan.learn.math.offer;


/**
 * NC127 最长公共子串
 *
 * 动态规划，以i,j结尾的连续字符串长度，不断遍历的过程中记录各个长度比较，记录长度与结尾坐标，反推即可
 *
 * <href>
 *     https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=117&&tqId=37799&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/04
 */
public class CaseNc127 {

    public String LCS (String str1, String str2) {
        int maxnum=0;
        int finish=0;
        //以i，j坐标结尾的字符串连续字符串，并非以i,j结尾的最长串
        int [][] dp=new int[str1.length()][str2.length()];
        for(int i=0;i<str1.length();i++) {
            for(int j=0;j<str2.length();j++) {
                if(str1.charAt(i)==str2.charAt(j)) {
                    //某个数组长度为0的情况下，字符相等，则最长公共串为1
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        //
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
                //与最大值进行比较
                if(dp[i][j]>maxnum) {
                    maxnum=dp[i][j];
                    finish=i;
                }
            }
        }
        if(maxnum==0){
            return "-1";
        }
        return str1.substring(finish+1-maxnum,finish+1);
    }

    public static void main(String[] args) {
        CaseNc127 caseNc127 = new CaseNc127();
        System.out.println(caseNc127.LCS("222221","222222"));
    }


}
