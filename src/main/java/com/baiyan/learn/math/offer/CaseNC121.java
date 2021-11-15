package com.baiyan.learn.math.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NC121 字符串的排列
 *
 * <href>
 *     https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=117&&tqId=37778&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/15
 */
public class CaseNC121 {
    public ArrayList<String> Permutation(String str) {
        List<String> resultList = new ArrayList<>();
        if(str.length() == 0){
            return (ArrayList)resultList;
        }
        //递归的初始值为（str数组，空的list，初始下标0）
        fun(str.toCharArray(),resultList,0);
        Collections.sort(resultList);
        return (ArrayList)resultList;
    }

    private void fun(char[] ch,List<String> list,int i){
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if(i == ch.length-1){
            //判断一下是否重复
            if(!list.contains(new String(ch))){
                list.add(new String(ch));
                return;
            }
        }else{
            //回溯，逐个交换遍历，交换完成拿到字符串之后再将交换的位子还原
            for(int j=i;j<ch.length;j++){
                swap(ch,i,j);
                fun(ch,list,i+1);
                swap(ch,i,j);
            }
        }
    }


    /**
     * 交换数组的两个下标的元素
     * @param str
     * @param i
     * @param j
     */
    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    public static void main(String[] args) {
        CaseNC121 caseNC121 = new CaseNC121();
        ArrayList<String> abc = caseNC121.Permutation("abc");
        System.out.println(abc.toString());

    }

}
