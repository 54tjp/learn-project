package com.learn.sort;

/**
 * @Description: 选择排序
 * @Author: tjp
 * @Date: 2023/9/17 9:59
 */
public class SelectionSort {

    /**
     * 选择排序是一种简单直观的排序算法，
     * 它的工作原理是每一次从待排序的数据元素中选出最小（最大）的一个元素，
     * 存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。
     * 选择排序是不稳定的排序方法
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮的最小值的下标
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            RightNum.swap(arr,i,min);
        }
    }
}
