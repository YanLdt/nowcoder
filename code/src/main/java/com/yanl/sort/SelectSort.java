package com.yanl.sort;

import java.util.Arrays;

/**
 * @author yanl
 * 选择排序
 * 从序列中选择最小元素放在第一个位置，然后在剩余的序列中再选出最小的元素放在首位
 * 所以时间复杂度为 N^2
 * 空间复杂度为O(1)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 8, 3, 7, 6};
//        bubbleSort(arr, arr.length);
        selectSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序
     * 就选择最小的放前面就完事了
     * @param arr
     * @param len
     */
    public static void selectSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            //找最小元素
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //将最小元素交换到前面
            if (i != minIndex) {
                swap(arr, minIndex, i);
            }
        }
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

