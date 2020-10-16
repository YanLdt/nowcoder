package com.yanl.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author YanL
 * @date 10:23 2020/10/16
 * 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 数组两端肯定是最大的
 * 使用双指针
 *
 */
public class L0997SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        int[] res = new int[len];
        int i = right;
        while (i >= 0){
            res[i] = A[left] * A[left] >= A[right] * A[right] ? A[left] * A[left ++] : A[right] * A[right --];
            i--;
        }
        return res;
    }
}
