package com.baiyan.learn.math.offer;

import java.util.ArrayList;

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
        char[] chars = str.toCharArray();
        ArrayList<String> results = new ArrayList<>();
        caculate(chars,results,0);
        return results;
    }

    /**
     * 计算结果，回溯法
     *
     *
     * @param chars
     * @param results
     * @param i
     */
    private void caculate(char[] chars,ArrayList<String> results,int i){
        //终止条件，i下标到了最后一个字符，单轮结束跳出递归
        if(i == chars.length-1){
            String result = new String(chars);
            if(!results.contains(result)){
                results.add(result);
            }
            return;
        }
        for (int j = i; j < chars.length; j++) {
            //交换顺序遍历
            swap(chars,i,j);
            //i+1递归的关键，表示着交换的状态逐层下推
            caculate(chars,results,i+1);
            //再将顺序交换回来
            swap(chars,i,j);
        }
    }

    /**
     * 数组下标数据交换，仅交换下标不同，并且对应的元素不同的情况
     *
     * @param chars
     * @param i
     * @param j
     */
    private void swap(char[] chars,int i,int j){
        if(i!=j && chars[i] != chars[j]){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }




    public static void main(String[] args) {
        CaseNC121 caseNC121 = new CaseNC121();
        ArrayList<String> abc = caseNC121.Permutation("abcdefg");
        System.out.println(abc.toString());

    }

}
