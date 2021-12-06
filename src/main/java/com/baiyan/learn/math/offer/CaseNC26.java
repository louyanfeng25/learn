package com.baiyan.learn.math.offer;

import java.util.ArrayList;

/**
 * 26.括号生成
 *
 * <href>
 *     https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=117&&tqId=37748&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/12/06
 */
public class CaseNC26 {

    ArrayList<String>  result = new ArrayList<>();

    public ArrayList<String> generateParenthesis (int n) {
        if(n<=0){
            return result;
        }
        generateParenthesis("",n,n);
        return result;
    }

    /**
     * 思路：
     * 1.保证剩余的左括号的数量永远小于等于右括号的数量
     * 2.左右括号都用完了，则将结果集添加
     *
     * @param str 字符串
     * @param left 剩余的左括号数量
     * @param right 剩余的右括号数量
     */
    private void generateParenthesis(String str,int left,int right){
        if(left==0 && right==0){
            result.add(str);
            return;
        }
        //左右括号相等，则下一个括号必须使用左括号，保证左括号小于等于右括号
        if(left==right){
            generateParenthesis(str+"(",left-1,right);
        }else {
            //如果左括号小于右括号的情况下，则下一个左右括号都可以，
            if(left>0){
                generateParenthesis(str+"(",left-1,right);
            }
            generateParenthesis(str+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        CaseNC26 caseNC26 = new CaseNC26();
        ArrayList<String> strings = caseNC26.generateParenthesis(3);
        strings.forEach(e-> System.out.println(e));
    }

}
