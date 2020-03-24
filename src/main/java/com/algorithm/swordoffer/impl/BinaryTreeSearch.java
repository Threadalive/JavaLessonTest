package com.algorithm.swordoffer.impl;

import java.util.Arrays;

/**
 * @Description 根据前序遍历和中序遍历重建二叉树
 * @Author zhenxing.dong
 * @Date 2020/3/24 15:34
 */
public class BinaryTreeSearch {
    /**
     * 递归实现
     * @param pre
     * @param mid
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] mid){
        if (pre == null||pre.length == 0||mid == null||mid.length == 0){
            return null;
        }
        if (pre.length != mid.length){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i<pre.length;i++){
            if (pre[0] == mid[i]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(mid,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(mid,i+1,mid.length));
            }
        }
        return root;
    }

}

