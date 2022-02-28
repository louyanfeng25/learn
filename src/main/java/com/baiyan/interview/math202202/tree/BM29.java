package com.baiyan.interview.math202202.tree;

/**
 * BM29 二叉树中和为某一值的路径(一)
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM29 {

    public boolean hasPathSum (TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        boolean b = false;
        if (root.left != null) {
            b = hasPathSum(root.left, sum - root.val);
        }
        if (b) {
            return b;
        }
        if (root.right != null) {
            b = hasPathSum(root.right, sum - root.val);
        }
        return b;
    }
}
