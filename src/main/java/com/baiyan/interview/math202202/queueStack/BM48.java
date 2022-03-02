package com.baiyan.interview.math202202.queueStack;

/**
 * BM48 数据流中的中位数
 *
 * @author baiyan
 * @date 2022-03-02
 */
public class BM48 {

    int[] ints = new int[1000];
    int count = 0;


    public void Insert(Integer num) {
        ints[count++] = num;
        BM46 bm46 = new BM46();
        bm46.quickSort(ints,0,count-1);
    }

    public Double GetMedian() {
        if(count%2==1){
            return (double)ints[count/2];
        }else {
            return ((ints[count/2]+ints[count/2-1])/2d);
        }
    }

}
