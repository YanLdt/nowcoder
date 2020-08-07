package com.yanl.sort;

import java.util.Arrays;

/**
 * @author YanL
 * @date 22:52 2020/8/7
 * 归并排序---使用分治法的思想
 * 最差时间复杂度为O(n*lgn)---类比二叉树
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 8, 3, 7, 6};
        System.out.println(Arrays.toString(mergeSortRecursive(arr, arr.length)));
    }

    /**
     * 递归对序列进行归并排序
     * @param arr
     * @param len
     * @return
     */
    public static int[] mergeSortRecursive(int[] arr, int len){
        if(len >= 2){
            int middle = len / 2;
            int[] left = Arrays.copyOfRange(arr, 0, middle);
            int[] right = Arrays.copyOfRange(arr, middle, len);
            //对两个子数组分别进行分组
            return merge(mergeSortRecursive(left, left.length), mergeSortRecursive(right, right.length));
        }
        return arr;
    }

    /**
     * 将两个有序子数组合并
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];
        for(int index = 0, i = 0, j = 0; index < res.length; index++){
            //左子序列遍历完了
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                //右子序列遍历完了
                res[index] = left[i++];
            } else if (left[i] > right[j]) {
                //右子序列的值较小，则将较小值放入结果集
                res[index] = right[j++];
            } else {
                //左子序列值较小
                res[index] = left[i++];
            }
        }
        return res;
    }
}
