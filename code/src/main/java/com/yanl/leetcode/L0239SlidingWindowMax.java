package com.yanl.leetcode;

/**
 * @author YanL
 * @date 21:42 2020/9/21
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class L0239SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int sum = 0;
        int[] res = new int[len - k + 1];
        for(int i = 0; i < k; i ++){
            sum += nums[i];
        }
        res[0] = sum;
        int left = 1;
        int right = left + k;
        for(int i = 1; i < res.length; i ++){
            sum += nums[right-1] - nums[left-1];
            res[i] = sum;
            left++;
            right++;
        }
        return res;
    }
}
