package com.baiyan.learn.math.offer;


/**
 * NC141 判断是否为回文字符串
 *
 * <href>
 *     https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2?tpId=117&&tqId=37852&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/18
 */
public class CaseNC113 {

    public boolean judge (String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left<right){
            if(chars[left]==chars[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
