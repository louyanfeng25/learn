package com.baiyan.learn.math.offer.casenc60;


import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * <href>
 *     https://www.nowcoder.com/practice/f31fc6d3caf24e7f8b4deb5cd9b5fa97?tpId=117&&tqId=37822&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * </href>
 *
 * @author baiyan
 * @time 2021/11/28
 */
public class CaseNc60 {

    public boolean[] judgeIt (TreeNode root) {
        if(root==null){
            return new boolean[]{true,true};
        }
        return new boolean[]{isAll(root)};
    }

    /**
     * 是否为完全二叉树
     *
     * @param root
     * @return
     */
    public boolean isAll(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //如果当前节点并不是左右孩子节点全有，那么之后存在于队列中的节点必须都为叶节点
                if (leaf && (node.left != null || node.right != null)) {
                    return false;
                }
                //如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false
                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    leaf = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CaseNc60 caseNc60 = new CaseNc60();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        boolean[] booleans = caseNc60.judgeIt(treeNode1);
        Stream.of(booleans).forEach(System.out::println);
    }


}
