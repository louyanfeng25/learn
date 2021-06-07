package com.baiyan.learn.math.offer;

/**
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 *
 * @author baiyan
 * @time 2021/6/7 16:46
 */
public class CaseOffer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int row = 0;
        int column = matrix[0].length-1;
        while (row < rows && column >=0){
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column]>target){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }

}
