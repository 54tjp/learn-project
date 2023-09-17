package com.learn.sort;

import com.learn.sort.cost.Cost;

import java.util.Arrays;

/**
 *
 * @Description: 对数器
 * @Author: tjp
 * @Date: 2023/9/16 22:53
 */
public class RightNum {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swapNew(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 1、实现一个绝对正确但是复杂度不好的方法B，使用的是JDK提供的Arrays类的排序方法
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 2、实现一个随机样本产生器
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //产生随机数范围为[0,maxSize]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //产生[-maxValue,maxValue]的元素
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 拷贝数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 3、实现比对的方法
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 5、如果有一个样本使得比对出错，打印样本分析是哪个方法出错
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        //4、把方法a和方法b比对很多次来验证方法a是否正确
        try(Cost cost = new Cost()) {
            for (int i = 0; i < testTime; i++) {
                int[] arr1 = generateRandomArray(maxSize, maxValue);
                int[] arr2 = copyArray(arr1);
                SelectionSort.selectionSort(arr1);
                comparator(arr2);
                if (!isEqual(arr1, arr2)) {
                    succeed = false;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        SelectionSort.selectionSort(arr);
        printArray(arr);
    }


}