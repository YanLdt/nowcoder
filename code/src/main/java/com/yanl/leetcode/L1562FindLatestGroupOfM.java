package com.yanl.leetcode;

/**
 * @author YanL
 * @date 10:55 2020/8/24
 * 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。
 * 有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
 * 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），
 * 二进制字符串上位于位置 arr[i] 的位将会设为 1 。
 * 给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。
 * 一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
 * 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
 */
public class L1562FindLatestGroupOfM {
    public int findLatestStep(int[] arr, int m){
        return binaryFind(arr, m, arr.length - 1, 0, arr.length - 1);
    }

    /**
     * 反向遍历，二分查找加速
     *
     * @param arr
     * @param m
     * @param index
     * @param left
     * @param right
     * @return
     */
    public int binaryFind(int[] arr, int m, int index, int left, int right){
        //当遍历到长度为m时返回
        if(m == right - left + 1){
            return index + 1;
        }
        //不满足条件 直接返回-1
        if(index < 0 || left < 0 || right > arr.length - 1 || right - left + 1 < m){
            return -1;
        }
        //如果当前值在左右区间内，则进行查找两边子集的最大连续长度 返回最大长度
        if(arr[index] - 1 >= left && arr[index] - 1 <= right){
            int boundary = arr[index] - 1;
            index--;
            int l = binaryFind(arr, m, index, left, boundary-1);
            int r = binaryFind(arr, m, index, boundary+1, right);
            return Math.max(l, r);
        }else{
            //不在区间内则继续反向遍历
            index--;
            return binaryFind(arr, m, index, left, right);
        }
    }

}
