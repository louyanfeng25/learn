package com.baiyan.interview.math202202.tree;

import java.util.ArrayList;

/**
 * BM23 二叉树的前序遍历
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM23 {

    ArrayList<Integer> objects = new ArrayList<>();

    public int[] preorderTraversal (TreeNode root) {
        preScan(root);
        int[] ints = new int[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            ints[i] = objects.get(i);
        }
        return ints;
    }

    private void preScan(TreeNode root){
        if(root==null){
            return;
        }
        objects.add(root.val);
        preScan(root.left);
        preScan(root.right);
    }

}
