package com.baiyan.interview.math202202.tree;

import java.util.ArrayList;

/**
 * BM25 二叉树的后序遍历
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM25 {

    ArrayList<Integer> objects = new ArrayList<>();

    public int[] postorderTraversal (TreeNode root) {
        postScan(root);
        int[] ints = new int[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            ints[i] = objects.get(i);
        }
        return ints;
    }

    private void postScan(TreeNode root){
        if(root==null){
            return;
        }
        postScan(root.left);
        postScan(root.right);
        objects.add(root.val);
    }
}
