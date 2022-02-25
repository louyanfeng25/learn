package com.baiyan.interview.math202202.halfsearch;

/**
 * BM20 数组中的逆序对
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM20 {

    private long count = 0;

    public int InversePairs(int [] array) {
        process(array,0,array.length-1);
        return (int)(count%1000000007);
    }

    /**
     * 二分法拆分数组
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int[] process(int [] array,int left, int right){
        if(left==right){
            return new int[]{array[left]};
        }
        int mid = left + (right- left)/2;
        int[] leftArray = process(array,left,mid);
        int[] rightArray = process(array,mid+1,right);
        return merge(leftArray,rightArray);
    }

    /**
     * 从小到大合并数组
     *
     * @param leftArray
     * @param rightArray
     * @return
     */
    private int[] merge(int [] leftArray,int [] rightArray){
        int[] mergeArray = new int[leftArray.length+rightArray.length];
        int cur = 0;
        int curLeft = 0;
        int curRight = 0;
        while (curLeft<leftArray.length && curRight<rightArray.length){
            if(leftArray[curLeft]>rightArray[curRight]){
                count = count + leftArray.length - curLeft;
                mergeArray[cur++] = rightArray[curRight++];
            }else {
                mergeArray[cur++] = leftArray[curLeft++];
            }
        }
        while (curLeft<leftArray.length){
            mergeArray[cur++] = leftArray[curLeft++];
        }
        while (curRight<rightArray.length){
            mergeArray[cur++] = rightArray[curRight++];
        }
        return mergeArray;
    }

    public static void main(String[] args) {
        BM20 bm20 = new BM20();
        int i = bm20.InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0});
        System.out.println(i);
    }


}
