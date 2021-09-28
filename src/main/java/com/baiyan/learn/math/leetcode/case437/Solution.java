package com.baiyan.learn.math.leetcode.case437;

import java.util.Objects;

/**
 * 437. 路径总和 III
 *
 * <href>
 *     https://leetcode-cn.com/problems/path-sum-iii/
 * </href>
 *
 * 思路：节点遍历
 *
 * @author baiyan
 * @date 2021/09/28
 */
class Solution {

    public static int count = 0;


    public int pathSum(TreeNode root, int targetSum) {
        circleSum(root,targetSum);
        return count;
    }

    public void circleSum(TreeNode root, int targetSum){
        if(Objects.isNull(root)){
            return;
        }
        if(Objects.isNull(root.left) && Objects.isNull(root.right)){
            rootSum(root,targetSum,0);
            return;
        }
        rootSum(root,targetSum,0);
        circleSum(root.left,targetSum);
        circleSum(root.right,targetSum);
    }

    public void rootSum(TreeNode root, int targetSum,int preSum){
        if(Objects.isNull(root)){
            return;
        }
        preSum = root.val + preSum;
        if(Objects.equals(preSum,targetSum)){
            count++;
        }
        if(Objects.isNull(root.left) && Objects.isNull(root.right)){
            return;
        }
        rootSum(root.left,targetSum,preSum);
        rootSum(root.right,targetSum,preSum);
    }

    private TreeNode createBinaryTreeByArray(Integer []array,int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public TreeNode testLevel() {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        return createBinaryTreeByArray(arr,0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pathSum(solution.testLevel(),22);
        System.out.println(count);
    }

}
