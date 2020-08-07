package com.yanl.sort;

import java.util.Arrays;

/**
 * @author yanl
 * 插入排序
 * 分为排序队列和非排序队列
 * 从非排序队列中选一个在排序对类中查找该插入的位置，将其插入
 * 一般是从未排序队列的第一个，然后再该当前元素的右边开始查找，寻找第一个小于该元素的元素位置
 * 时间复杂度：
 * 最好O(N)
 * 最坏O(n^2)
 * 空间复杂度O(1)  稳定排序
 */
public class InceptionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 8, 3, 7, 6};
//        bubbleSort(arr, arr.length);
        inceptionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void inceptionSort(int[] arr, int len){
        for (int i = 1; i < len; i++) {
            //此时需要插入的数据
            int cur = arr[i];
            int j = i;
            //遍历j之前的所有元素，如果存在小于当前元素的跳出
            while (j > 0 && cur < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            //然后将当前元素插入
            if(j != i){
                arr[j] = cur;
            }
        }
    }

}
