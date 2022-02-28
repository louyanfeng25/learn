package com.baiyan.interview.math202202.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM28 二叉树的最大深度
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM28 {

    public int maxDepth (TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }
        return count;
    }
}
