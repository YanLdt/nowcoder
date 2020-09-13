package com.yanl.leetcode;

/**
 * @author YanL
 * @date 0:24 2020/9/14
 * 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 出现负数的话会导致最大值与最小值互换
 * 所以要记录最小值的一个集合
 *
 */
public class L0152MaxProductSubArray {

    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        //max为以当前元素前一个元素结束的最大乘积子序列的最大值
        //min为最小值
        int max = nums[0];
        int min = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < len; i ++){
            //如果当前元素为负，需要将之前的最大值与最小值互换
            if(nums[i] < 0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            res = Math.max(max, res);
        }
        return res;
    }
}
