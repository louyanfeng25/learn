package com.baiyan.interview.math202202.tree;

/**
 * BM36 判断是不是平衡二叉树
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM36 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        //计算左边树高度，一旦存在高度为-1，则一路返回
        int left = getDepth(root.left);
        if(left==-1){
            return -1;
        }
        //计算右边树高度
        int right = getDepth(root.right);
        if(right==-1){
            return -1;
        }
        //计算高度差
        return Math.abs(left-right) > 1 ? -1 : 1 + Math.max(left,right);
    }

}
