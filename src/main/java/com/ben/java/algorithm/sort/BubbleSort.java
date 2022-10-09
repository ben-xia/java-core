package com.ben.java.algorithm.sort;

/**
 * 冒泡排序
 * @author ben xia
 * @date 2019年11月11日
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 4, 8, 7, 5, 1};
        arr = bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {  //外层循环
            int temp;
            for (int j = 0; j < arr.length - 1 - i; j++) { //内层循环
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        return arr;
    }

}
