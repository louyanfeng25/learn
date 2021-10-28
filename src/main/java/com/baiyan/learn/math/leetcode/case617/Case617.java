package com.baiyan.learn.math.leetcode.case617;

import java.util.Objects;

/**
 * 617. 合并二叉树
 *
 * <href>
 *     https://leetcode-cn.com/problems/merge-two-binary-trees/
 * </href>
 *
 * @author baiyan
 * @date 2021/10/28
 */
public class Case617 {

    /**
     * 层级遍历，逐层相加
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(Objects.isNull(root1)){
            return root2;
        }
        if(Objects.isNull(root2)){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left = mergeTrees(root1.left , root2.left);
        root.right = mergeTrees(root1.right , root2.right);
        return root;
    }




}
