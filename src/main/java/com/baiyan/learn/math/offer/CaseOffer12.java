package com.baiyan.learn.math.offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * 回溯算法解决
 * 单边遍历，碰到数组越界或者占位符号则返回false路径不通
 *
 * @author baiyan
 * @time 2021/6/7 20:55
 */
public class CaseOffer12 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                //从各个节点开始遍历，遍历方向为上下左右均可
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //i >= board.length || i < 0 || j >= board[0].length || j < 0 限定数组是否越界
        //board[i][j] != word[k]限定字符串是否遇到不相等的
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]){
            return false;
        }
        if(k == word.length - 1){
            return true;
        }
        //占位符，如果路径被访问过了则进行占位，题目中限制元素不可被重复访问
        board[i][j] = '\0';
        //上下左右开始递归遍历
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //针对某一个路线使用完成之后将占位符号恢复，这一步很重要，如果不恢复，将导致后续方案无法进行正常寻址
        board[i][j] = word[k];
        return res;
    }

}
