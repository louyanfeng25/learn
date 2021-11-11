package com.baiyan.learn.math.offer;


/**
 * NC7 买卖股票的最好时机(一)
 *
 * <href>
 *     https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=117&&tqId=37717&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/11
 */
public class CaseNC7 {

    public int maxProfit (int[] prices) {
        if(prices==null || prices.length==1 || prices.length==0){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else {
               max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CaseNC7 caseNC7 = new CaseNC7();
        //5
        System.out.println(caseNC7.maxProfit(new int[]{8,9,2,5,4,7,1}));
        //2
        System.out.println(caseNC7.maxProfit(new int[]{2,4,1}));
        //0
        System.out.println(caseNC7.maxProfit(new int[]{3,2,1}));
    }

}
