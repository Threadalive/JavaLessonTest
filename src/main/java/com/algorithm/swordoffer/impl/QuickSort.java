package com.algorithm.swordoffer.impl;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/3/31 15:27
 */
public class QuickSort {
    /**
     * 将数组中的基准数放至正确位置并返回index
     * @param arr 输入的数组
     * @param left 数组队首
     * @param right 数组队尾
     * @return 基准数index
     */
    public static int getIndex(int[] arr,int left,int right){
        //将基准数进行保存
        int temp = arr[left];
        while (left<right){
            //当数组right索引的值大于基准值时，向左移动指针
            while (left<right && arr[right] >= temp){
                right--;
            }

            arr[left] = arr[right];
            //当队首元素大于基准数时
            while (left<right && arr[left] <= temp){
                left++;
            }
            //将大于基准值的元素赋予right位置的元素
            arr[right] = arr[left];
        }
        //当跳出循环时，说明两指针汇合，将temp值赋予该位即可
        arr[left] = temp;
        return left;
    }

    public static void quickSort(int[] arr,int left,int right)throws Exception{
        if (null == arr||arr.length == 0){
            throw new Exception("输入空数组");
        }

//        if (arr.length == 1){
//            System.out.println("无需排序");
//        }
        if (left<right){
            int index = getIndex(arr,left,right);
            //递归排序基准数左边和右边的子数组
            quickSort(arr,left,index-1);
            quickSort(arr,index+1,right);
        }
    }
}
