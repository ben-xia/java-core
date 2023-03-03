package com.ben.java.algorithm.sort;

/**
 * @author: ben.xia
 * @desc: 归并排序*****[分治思想,分而治之]
 * @date: 2023/2/21
 */
public class MergeSort {
    public static final int THRESHOLD = 2; //阈值

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 4, 8, 7, 5, 1};
        int len = arr.length;
        mergeSort(arr,0,len-1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static void mergeSort(int[] arr,int left, int right) {
        if (left==right){return;}

        int mid=(left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        mergeTwoSortedArray(arr, left, mid, right);
    };

    /**
     * 把两个已经排好序的数组进行合并
     * 第 1 个数组：arr[left..mid]，是排好序的
     * 第 2 个数组：arr[mid + 1..right]，是排好序的
     *
     * @param arr   待排序数组
     * @param left  arr[left..mid] 已经是排好序的
     * @param mid
     * @param right arr[mid + 1..right] 已经是排好序的
     */
    private static void mergeTwoSortedArray(int[] arr, int left, int mid, int right) {
        // 首先计算出这个数组的长度
        // 因为是左边闭区间，右边闭区间，所以元素的个数就是：右边界 - 左边界 + 1
        int length = right - left + 1;
        // 新建一个数组，赋值，用于比较
        // 这里每进行一次比较，都要 new 一个数组，开销很大
        int[] temp = new int[length];
        // 为新数组赋值
        for (int i = 0; i < length; i++) {
            temp[i] = arr[left + i];
        }
        // 左边数组的起始位置
        int l = 0;
        // 右边数组的起始位置
        int r = mid - left + 1;

        // 循环遍历把 arr 在 [left..right] 这个区间重新赋值
        // temp 数组中的元素不动，只是拿来做比较，然后我们一直修改的是 arr 数组在 [left..right] 的值
        for (int i = 0; i < length; i++) {
            // 先考虑如果左边数组用完（越界）的情况
            if (l > mid - left) {
                // 此时 l 遍历完成，就去拼命遍历 r 就好了
                arr[i + left] = temp[r];
                r++;
            } else if (r > length - 1) {
                // 此时 r 遍历完成，就去拼命遍历 l 就好了
                arr[i + left] = temp[l];
                l++;
            } else if (temp[l] <= temp[r]) {
                arr[i + left] = temp[l];
                l++;
            } else {
                arr[i + left] = temp[r];
                r++;
            }
        }
    }

}
