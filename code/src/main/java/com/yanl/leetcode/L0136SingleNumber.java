package com.yanl.leetcode;

/**
 * @author YanL
 * @date 17:00 2020/9/3
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 */
public class L0136SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums == null){
            return -1;
        }
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
