package com.algorithm.swordoffer.impl;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/24 15:55
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parentNode;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}

