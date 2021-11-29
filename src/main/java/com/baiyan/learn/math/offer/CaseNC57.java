package com.baiyan.learn.math.offer;


import java.math.BigDecimal;

/**
 * NC57 反转数字
 *
 * <href>
 *     https://www.nowcoder.com/practice/1a3de8b83d12437aa05694b90e02f47a?tpId=117&&tqId=37755&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/29
 */
public class CaseNC57 {

    public int reverse (int x) {
        int flag;
        if(x>=0){
            flag=1;
        }else {
            flag=-1;
        }
        String s = String.valueOf(Math.abs(x));
        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while (left<right){
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        String s1 = new String(chars);
        BigDecimal max = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal s1Value = new BigDecimal(s1);
        if(max.compareTo(s1Value)!=-1){
            return s1Value.intValue()*flag;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        CaseNC57 caseNC57 = new CaseNC57();
        System.out.println(caseNC57.reverse(-321));

    }

}
