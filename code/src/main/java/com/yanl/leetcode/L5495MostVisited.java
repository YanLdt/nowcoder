package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanL
 * @date 10:33 2020/8/24
 * 给你一个整数 n 和一个整数数组 rounds 。
 * 有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。
 * 现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。
 * 其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。
 * 举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 * 只需考虑首尾就行   不需要模拟全过程
 */
public class L5495MostVisited {
    public List<Integer> mostVisited(int n, int[] rounds){
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        List<Integer> res = new ArrayList<>();
        //起始值小于末尾值，则遍历最多的是起始值和末尾值组成的区间
        if(start <= end){
            for(int i = start; i <= end; i++){
                res.add(i);
            }
        }else {
            //起始值大于末尾值，则结果是 1-末尾值 + 起始值-n的并集。
            for(int i = 1; i <= end; i++){
                res.add(i);
            }
            for(int i = start; i <= n; i++){
                res.add(i);
            }
        }
        return res;
    }
}
