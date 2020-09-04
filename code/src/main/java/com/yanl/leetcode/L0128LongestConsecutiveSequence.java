package com.yanl.leetcode;

import java.util.*;

/**
 * @author YanL
 * @date 9:42 2020/9/4
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 我只会先排序然后遍历
 *
 */
public class L0128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);

        int max = 1;
        int res = 1;
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i+1] - nums[i] == 1){
                res++;
            }else if (nums[i+1] == nums[i]){
                //相等跳过此次循环
                continue;
            }else{
                res = 1;
            }
            max = Math.max(max, res);
        }
        return max;
    }

    public int hashSetV(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int res = 1;
        for(int i : set){
            int curLen = 1;
            //遍历每个元素之前先判断当前元素-1是否在set中，
            // 因为如果存在的话则当前元素已经计算过
            if(!set.contains(i-1)){
                int cur = i;
                while (set.contains(cur + 1)){
                    cur++;
                    curLen++;
                }
            }
            res = Math.max(curLen, res);
        }
        return res;
    }

}
