package com.baiyan.interview.math202202.scanBackTrack;

import java.util.ArrayList;

/**
 * BM60 括号生成
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM60 {

    ArrayList<String> result = new ArrayList<>();

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
        //左右括号相等，只能添加左括号
        if(right==left){
            generateParenthesis(str+"(",left-1,right);
        }else {
            if(left>0){
                generateParenthesis(str+"(",left-1,right);
            }
            generateParenthesis(str+")",left,right-1);
        }
    }

}
