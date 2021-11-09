package com.baiyan.learn.math.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * NC54 数组中相加和为0的三元组
 *
 * <href>
 *      https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=117&&tqId=37751&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/09
 */
public class CaseNC54 {

    /**
     * 排序+双指针
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < num.length; i++){

            int l = i+1, r = num.length-1;
            //最左边的元素 重复跳过
            if(i > 0 && num[i] == num[i-1]){
                continue;
            }

            while(l < r){
                //中间元素重复跳过
                if((l > i+1 && num[l] == num[l-1])){
                    l++;
                    continue;
                }
                //结尾元素重复跳过
                if(r < num.length-1 && num[r] == num[r + 1]){
                    r--;
                    continue;
                }
                int sum = num[i] + num[l] + num[r];
                if(sum == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[l]);
                    temp.add(num[r]);
                    list.add(temp);
                    l++;
                    r--;
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        CaseNC54 caseNC54 = new CaseNC54();
        ArrayList<ArrayList<Integer>> lists = caseNC54.threeSum(new int[]{-10, 0, 10, 20, -10, -40});
        System.out.println(lists);
    }
}
