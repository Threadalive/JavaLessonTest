package com.algorithm.swordoffer.impl;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description 倒序打印链表
 * @Author zhenxing.dong
 * @Date 2020/3/20 17:34
 */
public class PrintLinkListReverse {

    /**
     * 使用栈结构暂存
     *
     * @param pHead
     * @return
     */
    public static ArrayList<Integer> printListReverse(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<ListNode>();

        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
        }

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            list.add(node.val);
        }
        return list;
    }

    /**
     * 递归实现
     *
     * @param pHead
     * @return
     */
    public static ArrayList<Integer> printListReverse2(ListNode pHead) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        if (pHead != null){
            if (pHead.next != null){
                printListReverse2(pHead.next);
            }
            list.add(pHead.val);
        }
        return list;
    }
}

    class ListNode {
        int val;
        ListNode next;
    }