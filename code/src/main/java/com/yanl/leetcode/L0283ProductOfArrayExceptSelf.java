package com.yanl.leetcode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 19:22 2020/9/21
 * 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 左右遍历一遍
 */
public class L0283ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        for(int i = 0; i < len; i ++){
            res[i] *= left;
            left *= nums[i];
        }
        for(int j = len - 1; j >= 0; j --){
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }
}
