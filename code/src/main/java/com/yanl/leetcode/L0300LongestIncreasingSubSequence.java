package com.yanl.leetcode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 16:49 2020/9/22
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 动规 dp[i]表示  以i结尾的最长上升子序列的长度\
 * 如果nums[i] > nums[j]  dp[i] = dp[j] + 1
 *
 */
public class L0300LongestIncreasingSubSequence {
    public int lengthoflis(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 最后整个算法流程为：
     *
     * 设当前已求出的最长上升子序列的长度为len（初始时为 11），
     * 从前往后遍历数组 nums，
     * 在遍历到 nums[i] 时：
     * 如果 nums[i]>d[len] ，
     * 则直接加入到 d 数组末尾，
     * 并更新 len=len+1；
     * 否则，在 d 数组中二分查找，
     * 找到第一个比 nums[i] 小的数 d[k] ，
     * 并更新 d[k+1]=nums[i]。
     *
     * @param nums
     * @return
     */
    public int binaryV(int[] nums){
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        int res = 0;
        for(int a : nums){
            int i = 0, j = res;
            //dp数组是一个递增数组，保存的相同长度序列的最小值
            //找到第一个比当前元素小的元素
            while (i < j){
                int m = (i + j) / 2;
                if(dp[m] < a){
                    i = m + 1;
                }else {
                    j = m;
                }
            }
            //然后更新dp数组，保证数组里的元素都是最小的
            dp[i] = a;
            //扩容数组
            if(res == j){
                res++;
            }
        }
        return res;
    }
}
