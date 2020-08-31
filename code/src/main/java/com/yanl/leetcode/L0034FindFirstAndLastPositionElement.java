package com.yanl.leetcode;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class L0034FindFirstAndLastPositionElement {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] res = new int[2];
        while (left <= right){
            int mid = left + (right - left) / 2;

        }
        return nums;
    }
}
