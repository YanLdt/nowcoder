package com.yanl.xiaohongshu;

/**
 * @author YanL
 * @date 19:21 2020/9/6
 *
 * 给定一个整数数组（可能存在重复元素），找出将数组中哪一段连续的数字排序之后，
 * 整个数组就会变成有序的（假定这里指的有序为升序）。返回连续的下标[s,e]。如果找不到这样的下标组合，
 * 或者数组已经是有序的，则返回[-1,-1]。
 *
 * 例如，数组 [1, 2, 3, 4, 10, 7, 9, 8, 8, 12, 13, 14, 19],
 * 返回[4,8]。
 * 数组[1, 2, 3, 4, 5, 6, 7, 8]，返回[-1,-1]。
 */
public class PartSort {
    public static int[] subSort(int[] arr){
        if(arr.length == 0){
            return new int[]{-1, -1};
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            if(arr[left] >= arr[right]){
                return new int[]{left, right};
            }
            left++;
            right--;
        }
        return new int[]{-1, -1};
    }
}
