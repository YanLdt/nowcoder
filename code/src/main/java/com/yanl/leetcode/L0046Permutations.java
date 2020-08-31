package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YanL
 * @date 15:51 2020/8/31
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 回溯
 */
public class L0046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //用一个数组标记是否已经访问过
        int[] visited = new int[nums.length];
        backTrack(nums, new ArrayList<>(), res, 0, visited);
        return res;
    }

    public void backTrack(int[] nums, List<Integer> subRes, List<List<Integer>> res, int index, int[] visited){
        //当子集的大小等于数组的大小时，将子集加入结果集
        if(subRes.size() == nums.length){
            res.add(new ArrayList<>(subRes));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(visited[i] == 1){
                continue;
            }
            subRes.add(nums[i]);
            //访问之后置为1
            visited[i] = 1;
            backTrack(nums, subRes, res, i+1, visited);
            //回溯之后置为0
            visited[i] = 0;
            subRes.remove(subRes.size()-1);
        }
    }
}
