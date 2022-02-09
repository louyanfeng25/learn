package com.baiyan.learn.math.offer.casenc45;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 树的前中后序遍历
 *
 * 递归思路解决
 *
 * @author baiyan
 * @date 2021/11/01
 */
public class CaseNC45 {

    private List<Integer> first = new ArrayList<>();

    private List<Integer> middle = new ArrayList<>();

    private List<Integer> then = new ArrayList<>();

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

    private int[] toIntArray(List<Integer> array){
        if(Objects.isNull(array) || array.size()==0){
            return new int[0];
        }
        int[] ints = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            ints[i] = array.get(i);
        }
        return ints;
    }

    private void firstOrder(TreeNode root){
        if(Objects.isNull(root)){
            return;
        }
        first.add(root.val);
        firstOrder(root.left);
        firstOrder(root.right);
    }

    private void middleOrder(TreeNode root){
        if(Objects.isNull(root)){
            return;
        }
        middleOrder(root.left);
        middle.add(root.val);
        middleOrder(root.right);
    }

    private void thenOrder(TreeNode root){
        if(Objects.isNull(root)){
            return;
        }
        thenOrder(root.left);
        thenOrder(root.right);
        then.add(root.val);
    }



}
