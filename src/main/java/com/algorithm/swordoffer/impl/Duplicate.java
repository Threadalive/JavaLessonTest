package com.algorithm.swordoffer.impl;

import java.util.HashSet;

/**
 * @Description n大小数组中，数字范围在0~n-1，找出数组中任意重复的数
 * @Author zhenxing.dong
 * @Date 2020/3/20 16:15
 */
public class Duplicate {
    /**
     * 使用 HashSet
     * @param numbers
     * @return
     */
    public static Integer findDuplicate(int numbers[]){
        if (null == numbers || numbers.length == 0){
            return null;
        }
        if (numbers.length == 1){
            return numbers[0];
        }
        int length = numbers.length;

        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int index = 0;index<length;index++){
            if (!hashSet.add(numbers[index])){
                return numbers[index];
            }
        }
        return null;
    }

    /**
     * 在原数组上交换元素
     * @param numbers
     * @return
     */
    public static Integer findDuplicate2(int numbers[]){
        if (null == numbers || numbers.length == 0){
            return null;
        }
        if (numbers.length == 1){
            return numbers[0];
        }
        int length = numbers.length;

        for (int index = 0;index<length;index++){
            while (index != numbers[index]){
                if (numbers[index] == numbers[numbers[index]]){
                    return numbers[index];
                }else {
                    int temp = numbers[index];
                    numbers[index] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
      return null;
    }
}
