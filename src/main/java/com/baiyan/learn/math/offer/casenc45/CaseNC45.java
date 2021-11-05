package com.baiyan.learn.math.offer.casenc45;


import java.util.ArrayList;

/**
 * 树的前中后序遍历
 *
 * 递归思路解决
 *
 * @author baiyan
 * @date 2021/11/01
 */
public class CaseNC45 {

    //先序遍历存储数组
    public ArrayList<Integer> first = new ArrayList<>();
    //中序遍历存储数组
    public ArrayList<Integer> middle = new ArrayList<>();
    //后续遍历存储数组
    public ArrayList<Integer> then = new ArrayList<>();
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        //关键点
        //1.确定存储数组大小 OR 使用 ArrayList
        //2.前中后遍历算法
        //3.ArrayList 数组转 int[] 数组方法
        firstOrder(root);
        middleOrder(root);
        thenOrder(root);
        int[][] result = new int[3][first.size()];
        result[0]=toIntArray(first);
        result[1]=toIntArray(middle);
        result[2]=toIntArray(then);
        return result;

    }

    //ArrayList 转 int[]
    public int[] toIntArray(ArrayList<Integer> list){
        if(list==null||list.size()<1){
            return new int[0];
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    //先序遍历
    public void firstOrder(TreeNode root){
        //跳出条件
        if(root==null){
            return;
        }
        first.add(root.val);
        firstOrder(root.left);
        firstOrder(root.right);

    }

    //中序遍历
    public void middleOrder(TreeNode root){
        //跳出条件
        if(root==null){
            return;
        }
        middleOrder(root.left);
        middle.add(root.val);
        middleOrder(root.right);

    }

    //后序遍历
    public void thenOrder(TreeNode root){
        //跳出条件
        if(root==null){
            return;
        }
        thenOrder(root.left);
        thenOrder(root.right);
        then.add(root.val);
    }



}
