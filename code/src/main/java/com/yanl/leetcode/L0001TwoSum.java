package com.yanl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YanL
 * @date 23:33 2020/8/19
 * 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。
 * 使用一个hashMap来存放数组中的元素 元素作为hashKey,下标作为value
 * 判断target-nums[i]是否是hashMap的key。
 * 暴力的话需要两重循环  复杂度为n2
 * HashMap只需要遍历一次复杂度变为On
 */
public class L0001TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                return new int[]{i, map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
