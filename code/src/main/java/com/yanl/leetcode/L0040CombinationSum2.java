package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YanL
 * @date 14:49 2020/8/31
 * 组合总和2
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class L0040CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    public void backTrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> subRes, int index){
        if(target == 0){
            res.add(new ArrayList<>(subRes));
            return;
        }else if(target < 0){
            return;
        }else {
            for(int i = index; i < candidates.length; i ++){
                if(target < candidates[i]){
                    break;
                }
                //这边大于index才进行剪枝，除去迭代入口那一层的相等元素
                if(i > index && candidates[i] == candidates[i-1]){
                    continue;
                }
                subRes.add(candidates[i]);
                //System.out.println(subRes.toString());
                backTrack(candidates, target - candidates[i], res, subRes, i+1);
                subRes.remove(subRes.size() - 1);
                //System.out.println(subRes.toString());
            }
        }
    }
}
