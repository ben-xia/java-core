package com.ben.java.algorithm.sort;

/**
 * 二分法查找算法思路: 准备一个有序的数组, 不断的与中间下标的值比大小
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 8, 9, 10, 18, 90};
        System.out.println(binarySearch(90, arr));

    }

    /**
     * 返回要查找的value在数组中的下标,如果没找到返回-1
     * @param value
     * @param arr
     * @return
     */
    public static int binarySearch(int value, int[] arr) {
        int head, mid, tail;
        head = 0;
        tail = arr.length - 1;

        if (value > arr[arr.length - 1] || value < arr[0]) {
            return -1;
        }

        while (head <= tail) {
            mid = (head + tail) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value > arr[mid]) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return -1;
    }

}
