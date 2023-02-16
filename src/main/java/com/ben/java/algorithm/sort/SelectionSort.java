package com.ben.java.algorithm.sort;

/**
 * 选择排序算法思路: 以某个下标的值为参考作为最小值, 不断的与其后面的值比大小, 如果发现有比参考值更小的值
 * 则更新最小值的下标,在那到这个最小值与后面的值比大小,知道拿到了最小值得下标, 当发现参考值的下标与最小值
 * 的下标不一样时,进行值得交换;
 *
 * @author ben xia
 * @date 2019年11月11日
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 4, 8, 7, 5, 1};
        arr = selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
