package com.baiyan.interview.math202202.tree;

/**
 * BM34 判断是不是二叉搜索树
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM34 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST (TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if(root.val<=pre){
            return false;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left&&right;
    }

}
