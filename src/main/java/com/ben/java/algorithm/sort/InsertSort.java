package com.ben.java.algorithm.sort;

/**
 * @author: ben.xia
 * @desc: 插入排序*****  -  适用于数据量比较小 或者 接近有序数组
 * @date: 2023/2/21
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 4, 8, 7, 5, 1};
//        arr = insertSort01(arr);
        arr = insertSort02(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    /*自己第一时间写的垃圾代码*/
    public static int[] insertSort01(int[] arr) {
        // 注意边界
        int j;
        for (int i = 0; i < arr.length - 1; i++) {
            j = i;
            do {
                if (arr[j + 1] > arr[j]) {
                    break;
                }
                //交换
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            } while (j >= 0);
        }
        return arr;
    }


    /**
     * 只有赋值,没有交换
     * @param arr
     * @return
     */
    public static int[] insertSort02(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0) {
                if (temp < arr[j - 1]) {//交换
                    arr[j] = arr[j - 1];
                    j--;
                }else {
                    break;
                }
            }

            if (i != j) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
