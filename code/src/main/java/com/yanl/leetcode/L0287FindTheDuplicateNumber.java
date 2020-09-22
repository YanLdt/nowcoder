package com.yanl.leetcode;

/**
 * @author YanL
 * @date 14:00 2020/9/22
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *  二分查找？查找在某个范围内的数字
 */
public class L0287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) >> 1;
            int cnt = 0;
            //计算比mid值小的个数
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            //如果比中间值小的个数小于中间值，说明重复值在另一边
            //抽屉原理
            if(cnt <= mid){
                left = mid + 1;
            }else {
                //如果个数大于中间值，说明重复值在小于这一侧
                right = mid;
            }
        }
        return right;
    }
}
