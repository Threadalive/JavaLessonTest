package com.algorithm.swordoffer.impl;

/**
 * @Description 从上到下，从左到右递增的二维数组查找目标值
 *
 * @Author zhenxing.dong
 * @Date 2020/3/20 16:51
 */
public class FindNumIn2Arr {
    /**
     * 双指针查询,从右上角开始查
     * @param arr
     * @param target
     * @return
     */
    public static boolean findNum(int[][] arr,int target){
        if (null == arr || arr.length == 0){
            return false;
        }
        int row = 0;
        int col = arr[0].length - 1;

        while (row < arr.length && col >= 0){
            if (arr[row][col] == target){
                return true;
            }else if (arr[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }


    /**
     * 二分法查询
     * @param arr
     * @param target
     * @return
     */
    public static boolean findNum2(int[][] arr,int target){
        if (null == arr || arr.length == 0){
            return false;
        }

        int left = 0;
        int right = arr.length * arr[0].length -1;
        int col = arr[0].length;

        while (left<right){
            int mid = (left + right) >> 1;
            //中间元素的值
            int val = arr[mid/col][mid%col];

            if (val == target){
                return true;
            }else if (val < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }

    }
