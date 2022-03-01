package com.baiyan.interview.math202202.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BM41 输出二叉树的右视图
 *
 * @author baiyan
 * @date 2022-03-01
 */
public class BM41 {

    public int[] solve (int[] xianxu, int[] zhongxu) {
        BM40 bm40 = new BM40();
        TreeNode dfs = bm40.dfs(xianxu, 0, xianxu.length - 1, zhongxu, 0, zhongxu.length - 1);
        if(dfs==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(dfs);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(i==0){
                    result.add(poll.val);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }


}
