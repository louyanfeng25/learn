package com.baiyan.interview.math202202.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * BM26 求二叉树的层序遍历
 *
 *
 * @author baiyan
 * @date 2022-02-28
 */
public class BM26 {

    /**
     * 队列思路
     *
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(Objects.isNull(root)){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right !=null){
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }

        return result;
    }

}
