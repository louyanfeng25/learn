package com.baiyan.interview.math202202.halfsearch;

/**
 * BM18 二维数组中的查找
 *
 * @author baiyan
 * @date 2022-02-25
 */
public class BM18 {

    /**
     * 从右上角开始遍历
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int x = 0;
        int y = array[0].length-1;
        while (x<array.length && y>=0){
            if(array[x][y] == target){
                return true;
            } else if(array[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }

}
