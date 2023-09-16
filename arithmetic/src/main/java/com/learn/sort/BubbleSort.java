package com.learn.sort;

/**
 * @Description: 冒泡排序
 * @Author: tjp
 * @Date: 2023/9/16 22:53
 */
public class BubbleSort {

    /**
     * 冒泡排序的思想，我们要把相邻的元素两两比较，根据大小来交换元素的位置
     * isSorted 用于优化冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        // 1. 遍历 arr.length 次
        for (int i = 0; i < arr.length; i++) {
            // 2. arr.length - i - 1
            // -1: 最后一个数不进行任何比较 故-1
            // -i: 每循环完一轮 就会为 arr.length - i位置的数排好序 下一轮次位置的数不再进行比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    RightNum.swap(arr,j,j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序的思想，我们要把相邻的元素两两比较，根据大小来交换元素的位置
     * isSorted 用于优化冒泡排序
     * @param arr
     */
    public static void bubbleSortOptimize(int[] arr){
        // 1. 遍历 arr.length 次
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            // 2. arr.length - i - 1
            // -1: 最后一个数不进行任何比较 故-1
            // -i: 每循环完一轮 就会为 arr.length - i位置的数排好序 下一轮次位置的数不再进行比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    RightNum.swap(arr,j,j + 1);
                    // 本轮进行过排序 将次字段设置为false 没有进行过排序说明此数据有序
                    if(isSorted){
                        isSorted = false;
                    }
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

}
