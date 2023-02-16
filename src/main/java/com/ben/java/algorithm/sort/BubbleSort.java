package com.ben.java.algorithm.sort;

/**
 * 冒泡排序算法思路:
 * 外循环次数: 数组长度-1,
 * 内循环次数:数组长度-1-外循环已循环的次数(外循环每结束一次就找到了一个值)
 * 内循环的核心思想: 假定当前循环次数的下标值就是最大值, 它与它的下一个下标值比大小, 如果当前值比下一个下标
 * 的值更大, 则将当前值与下一个值做交换,这样的结果是每次循环次数拿到的数组下标的值都是当前最大的值;
 *
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
