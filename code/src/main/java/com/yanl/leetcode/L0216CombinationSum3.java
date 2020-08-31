package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanL
 * @date 15:29 2020/8/31
 * 组合总和3
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 依旧回溯
 * 模板：
 * 
 */
public class L0216CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] can = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        backTrack(can, n, k, res, new ArrayList<>(), 0);
        return res;
    }
    public void backTrack(int[] can, int target, int k, List<List<Integer>> res, List<Integer> subRes, int index){
        if(target == 0 && k == 0){
            res.add(new ArrayList<>(subRes));
        }
        if(target < 0 || (target > 0 && k <= 0)){
            return;
        }
        for(int i = index; i < can.length; i ++){
            if(target < can[i]){
                break;
            }
            subRes.add(can[i]);
            backTrack(can, target - can[i], k-1, res, subRes, i+1);
            subRes.remove(subRes.size() - 1);
        }
    }

}
