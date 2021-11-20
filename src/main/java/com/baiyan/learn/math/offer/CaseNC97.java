package com.baiyan.learn.math.offer;


import java.util.*;

/**
 * NC97 字符串出现次数的TopK问题
 *
 * <href>
 *     https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=117&&tqId=37809&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/20
 */
public class CaseNC97 {

    public String[][] topKstrings (String[] strings, int k) {
        Map<String,Integer>  map  = new HashMap<>();
        for (String string : strings) {
            map.put(string,map.getOrDefault(string, 0)+1);
        }
        Set<String> set = map.keySet();
        ArrayList<String> list = new ArrayList<>(set);
        list.sort((s1,s2)->Objects.equals(map.get(s1),map.get(s2)) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
        String[][] result = new String[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = new String[]{list.get(i),String.valueOf(map.get(list.get(i)))};
        }
        return result;
    }

}
