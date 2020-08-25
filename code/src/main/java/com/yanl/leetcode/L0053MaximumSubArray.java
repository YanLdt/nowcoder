package com.yanl.leetcode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 9:59 2020/8/25
 * 给定一个整数数组，找到一个具有最大和的连续子数组。至少包含一个元素，返回最大和
 * dp[i]表示以i结尾的连续数组的最大和
 * dp[0] = nums[0]
 */
public class L0053MaximumSubArray {
    public int maxSubArray(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < len; i ++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
