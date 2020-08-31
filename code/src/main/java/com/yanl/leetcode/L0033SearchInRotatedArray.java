package com.yanl.leetcode;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class L0033SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            if(nums[left] == target){
                return left;
            }
            if(nums[right] == target){
                return right;
            }
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //分开的两部分一定有一部分是有序的
            if(nums[left] < nums[mid]){
                //左半部分有序
                if(nums[mid] > target && nums[left] < target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else{
                //右半部分有序
                if(nums[mid] < target && target < nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
