package com.algorithm.swordoffer.impl;

import java.util.Stack;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/24 16:37
 */
public class DoubleStackQueue {
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    /**
     * 入栈 s1
     *
     * @param node
     */
    public void push(int node) {
        s1.push(node);
    }

    public int pop() throws Exception{
        if (s1.isEmpty()&&s2.isEmpty()){
            throw new Exception("空栈");
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
