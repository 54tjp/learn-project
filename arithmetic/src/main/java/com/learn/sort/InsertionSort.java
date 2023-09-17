package com.learn.sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author: tjp
 * @Date: 2023/9/17 10:20
 */
public class InsertionSort {

    /**
     * 插入排序
     * 1.第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = temp;

        }
    }
}
