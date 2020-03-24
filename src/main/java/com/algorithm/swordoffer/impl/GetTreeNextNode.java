package com.algorithm.swordoffer.impl;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/24 16:05
 */
public class GetTreeNextNode {
    public static TreeNode getNextNode(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }

        //当给出的结点有右子树时，下一个结点为右子树的最左结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        //当给出结点无右子树，且为父节点左子节点时，下一个结点为父节点
        if (pNode.parentNode != null && pNode.parentNode.left == pNode) {
            return pNode.parentNode;
        }

        //当给出结点无右子树，且为父节点右子节点时，下一个节点为父节点为左子节点的父节点

        while (pNode.parentNode != null) {
            if (pNode.parentNode == pNode.parentNode.parentNode.left) {
                return pNode.parentNode.parentNode;
            }
            pNode = pNode.parentNode;
        }
        return null;
    }
}
