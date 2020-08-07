package com.yanl.sort;

import java.util.Arrays;

/**
 * @author YanL
 * @date 23:35 2020/8/7
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 8, 3, 7, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition+1, right);
        }
    }

    /**
     * 返回partition在序列中的位置
     * 通过遍历把小于基准元素的放在左边，大于基准元素的放在右边
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right){
        int tmp = arr[left];
        while(left < right){
            //这边是先查找比基准元素小的元素位置，从右往左找
            while (left < right && arr[right] >= tmp){
                right--;
            }
            //找到之后将小于基准元素的元素放到基准元素位置
            arr[left] = arr[right];
            //接着找比基准元素打的位置，这次从左往右找
            while(left < right && arr[left] <= tmp){
                left++;
            }
            //找到比基准元素大的元素之后把该元素换到右边
            arr[right] = arr[left];
            //之后再循环查找  知道left = right  此时 ；left即为基准元素应该在的位置，左侧都是小于，右侧都是大于
        }
        arr[left] = tmp;
        return left;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
