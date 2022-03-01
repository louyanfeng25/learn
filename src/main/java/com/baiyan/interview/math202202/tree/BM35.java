package com.baiyan.interview.math202202.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BM35 判断是不是完全二叉树
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM35 {

    public boolean isCompleteTree (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //如果已经形成叶子树，则左右节点都必须为空
                if(leaf && (poll.right!=null || poll.left!=null)){
                    return false;
                }
                //不存在左节点为空，右节点不为空的情况
                if(poll.left == null && poll.right!=null){
                    return false;
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                //右节点一旦为空标识进入完全二叉树判断
                if(poll.right!=null){
                    queue.add(poll.right);
                }else {
                    leaf = true;
                }
            }
        }
        return true;
    }
}
