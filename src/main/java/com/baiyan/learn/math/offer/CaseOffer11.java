package com.baiyan.learn.math.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author baiyan
 * @time 2021/6/7 19:43
 */
public class CaseOffer11 {

    public int minArray(int[] numbers) {
        int n = -1;
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i+1]<numbers[i]){
                n = numbers[i+1];
                break;
            }
        }
        if(n==-1){
            n = numbers[0];
        }
        return n;
    }

    public static void main(String[] args) {
        CaseOffer11 caseOffer11 = new CaseOffer11();
        System.out.println(caseOffer11.minArray(new int[]{1,2,3,4,5}));
    }

}
