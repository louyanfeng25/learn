package com.baiyan.learn.math.leetcode;


/**
 * 733. 图像渲染
 *
 * <href>
 *     https://leetcode-cn.com/problems/flood-fill/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/27
 */
public class Case733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        helper(image, sr, sc, newColor, image[sr][sc]);

        return image;

    }

    void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {

        //newColor == oldColor 这一步判断特别重要，防止陷入循环修改
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || newColor == oldColor){
            return;
        }

        image[sr][sc] = newColor;

        helper(image, sr - 1, sc, newColor, oldColor);
        helper(image, sr + 1, sc, newColor, oldColor);
        helper(image, sr, sc - 1, newColor, oldColor);
        helper(image, sr, sc + 1, newColor, oldColor);
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Case733 case733 = new Case733();
        System.out.println(case733.floodFill(ints,1,1,2));
    }
}
