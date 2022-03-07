package com.baiyan.interview.math202202.scanBackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * BM58 字符串的排列
 *
 * @author baiyan
 * @date 2022-03-07
 */
public class BM58 {

    List<String> resultList = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        if(str.length() == 0){
            return (ArrayList)resultList;
        }
        backTrack(str.toCharArray(),new StringBuilder(),new boolean[str.length()]);
        return (ArrayList)resultList;
    }

    private void backTrack(char[] chars,StringBuilder sb,boolean[] mark){
        if(chars.length == sb.length() && !resultList.contains(sb.toString())){
            resultList.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(mark[i] || i>0 && chars[i]==chars[i-1] && !mark[i-1]){
                continue;
            }
            mark[i] = true;
            sb.append(chars[i]);

            backTrack(chars,sb,mark);

            sb.deleteCharAt(sb.length()-1);
            mark[i] = false;
        }
    }

    public static void main(String[] args) {
        BM58 bm58 = new BM58();
        ArrayList<String> abc = bm58.Permutation("aab");
        System.out.println(abc.toString());
    }

}
