package com.yanl.leetcode;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 二分查找
 * 找到目标元素就开始遍历左右两边
 */
public class L0034FindFirstAndLastPositionElement {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] res = new int[2];
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                int l = mid - 1;
                int r = mid + 1;
                while (l >= 0 && nums[l] == target){
                    l--;
                }
                res[0] = l+1;
                while (r < len && nums[r] == target){
                    r++;
                }
                res[1] = r-1;
                return res;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
