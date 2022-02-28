package com.baiyan.interview.math202202.tree;

import java.util.ArrayList;

/**
 * BM24 二叉树的中序遍历
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM24 {

    ArrayList<Integer> objects = new ArrayList<>();

    public int[] inorderTraversal (TreeNode root) {
        middleScan(root);
        int[] ints = new int[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            ints[i] = objects.get(i);
        }
        return ints;
    }

    private void middleScan(TreeNode root){
        if(root==null){
            return;
        }
        middleScan(root.left);
        objects.add(root.val);
        middleScan(root.right);
    }
}
