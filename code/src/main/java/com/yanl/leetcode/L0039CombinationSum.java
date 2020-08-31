package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YanL
 * @date 13:06 2020/8/31
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 回溯算法
 */
public class L0039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    public void backTrack(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> subRes){
        if(target < 0){
            return;
        }else if(target == 0){
            res.add(new ArrayList<>(subRes));
        }else {
            //防止重复
            for(int i = index; i < candidates.length; i ++){
                if(target < candidates[i]){
                    break;
                }
                subRes.add(candidates[i]);
                backTrack(candidates, target - candidates[i], i, res, subRes);
                subRes.remove(subRes.size()-1);
            }
        }
    }
}
