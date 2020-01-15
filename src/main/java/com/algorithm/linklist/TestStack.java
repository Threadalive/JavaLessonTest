package com.algorithm.linklist;

import java.util.Stack;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/1/8 16:10
 */
public class TestStack {
    public static void main(String args[]){
        Stack<String> stack = new Stack<String>();
        stack.add("1");
        stack.add("2");
        stack.add("3");

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}
