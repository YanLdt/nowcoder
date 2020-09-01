package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanL
 * @date 18:40 2020/9/1
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 回溯模板
 * 每次回溯都把子集添加到结果集
 */
public class L0078Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backTrack(int[] nums, int index, List<Integer> sub, List<List<Integer>> res){
        res.add(new ArrayList<>(sub));
        for(int i = index; i < nums.length; i ++){
            sub.add(nums[i]);
            backTrack(nums, i+1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}
