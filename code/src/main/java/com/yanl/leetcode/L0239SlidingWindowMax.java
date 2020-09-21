package com.yanl.leetcode;

import java.util.LinkedList;

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
 *  使用双端队列
 *
 */
public class L0239SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return nums;
        }

        //双向队列，保存当前窗口最大值的数组位置
        LinkedList<Integer> queue = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for(int i = 0; i < len; i ++){
            //res[i] = findMax(nums, i, i + k);
            //如果当前元素大于队列最后元素，则弹出队列最后一个元素
            //保证队首是最大元素的下标
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            //每次都从后面入队
            queue.addLast(i);
            //如果当前最前元素不在窗口内，则弹出最前元素
            if(queue.peek() <= i - k){
                queue.poll();
            }
            //当到达窗口末尾时，队列最前元素就是结果
            if(i + 1 >= k){
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }


    /**
     * 暴力超时
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int findMax(int[] nums, int left, int right){
        int res = Integer.MIN_VALUE;
        for(int i = left; i < right; i ++){
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
