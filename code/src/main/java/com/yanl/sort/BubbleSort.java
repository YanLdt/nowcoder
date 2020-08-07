package com.yanl.sort;

import java.util.Arrays;

/**
 * @author yanl
 * 算法分析：稳定排序算法
 * 最好情况为O(N)数组有序，遍历一次
 * 最坏情况O(n^2)数组完全倒序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 8, 3, 7, 6};
//        bubbleSort(arr, arr.length);
        bubbleSortV2(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 默认方法，遍历全部元素
     * 可能会有无用功
     * 可以加一个标志判断是否已经完成
     * @param arr
     * @param len
     * @return
     */
    public static void bubbleSort(int[] arr, int len){
        for(int i = 0; i < len-1; i++){
            for(int j = 0; j < len-1-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * 冒泡优化
     * 遍历一次之后判断当前序列是否已经有序，有序则直接返回，不需要做无用功
     * @param arr
     * @param len
     */
    public static void bubbleSortV2(int[] arr, int len){
        for(int i = 0; i < len - 1; i++){
            boolean flag = true;
            for(int j = 0; j < len - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    flag = false;
                }
            }
            //遍历一遍之后如果没有发生交换说明当前数组已经有序
            if(flag){
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
