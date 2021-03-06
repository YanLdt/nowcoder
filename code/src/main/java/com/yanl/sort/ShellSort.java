package com.yanl.sort;

import java.util.Arrays;

/**
 * @author YanL
 * @Time: 22:30 2020/8/7
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 希尔排序
 * 递减增量排序----基于插入排序
 * 间隔为gap的插排
 * gap为1时则为正常插排
 * 经过前面gap排序，序列已经基本有序，这是插排速度很快
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 8, 3, 7, 6};
//        bubbleSort(arr, arr.length);
        shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }


    public static void shellSort(int[] arr, int len){
        int gap = len / 2;
        while (gap > 0){
            for(int i = gap; i < len; i++){
                int temp = arr[i];
                int preIndex = i - gap;
                //这边进行插入排序 不过间隔是gap
                while(preIndex > 0 && temp < arr[preIndex]){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }
}
