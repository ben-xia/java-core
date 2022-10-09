package com.ben.java.algorithm.sort;

/**
 * 快速排序: 非常经典,现实中应用的最快的排序算法,实际用的是递归思想
 * (特别针对大数据 - 实现细节很重要)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 40, 2, 1, 8, 9, 19,50,0};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, pivot, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        pivot = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = pivot;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j +1, high);
    }

}
