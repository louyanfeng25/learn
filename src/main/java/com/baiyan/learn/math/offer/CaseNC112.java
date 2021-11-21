package com.baiyan.learn.math.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * NC112 进制转换
 *
 * <href>
 *     https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=117&&tqId=37836&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/21
 */
public class CaseNC112 {

    public String solve (int M, int N) {
        if(M==0){
            return "0";
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        int abs = Math.abs(M);
        String a = "";
        while (abs>=N){
            int result = abs%N;
            a = String.valueOf(result>9 ? map.get(result) : result)+a;
            abs = abs/N;
        }
        a = String.valueOf(abs>9 ? map.get(abs) : abs)+a;
        if(M<0){
            a = "-"+a;
        }

        return a;
    }

    public static void main(String[] args) {
        CaseNC112 caseNC112 = new CaseNC112();
        System.out.println(caseNC112.solve(10,16));
    }

}
