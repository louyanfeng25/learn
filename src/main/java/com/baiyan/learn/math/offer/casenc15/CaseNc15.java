package com.baiyan.learn.math.offer.casenc15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * NC15 求二叉树的层序遍历
 *
 * @author baiyan
 * @date 2021/11/01
 */
public class CaseNc15 {

    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(Objects.isNull(root)){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tempList.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        ArrayList<ArrayList<Integer>> arrayLists = CaseNc15.levelOrder(root);
        System.out.println(arrayLists);
    }
}
