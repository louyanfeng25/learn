package com.baiyan.learn.math.offer.casenc13;


import java.util.LinkedList;
import java.util.Queue;

/**
 * NC13 二叉树的最大深度
 *
 * <href>
 *     https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=117&&tqId=37721&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/18
 */
public class CaseNC12 {

    public int maxDepth (TreeNode root) {
        if(root==null){
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return count;
    }

}
