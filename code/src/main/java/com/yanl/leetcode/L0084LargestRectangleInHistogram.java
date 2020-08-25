package com.yanl.leetcode;

/**
 * @author YanL
 * @date 18:28 2020/8/25
 * 给定n个非负整数，用来表示柱状图中各个柱子的高度，每个柱子彼此相邻，且宽度为1，
 * 求在该柱状图中能勾勒出的矩形的最大面积
 */
public class L0084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int res = 0;
        for(int i = 0; i < len; i ++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < len; j ++){
                minHeight = Math.min(minHeight, heights[j]);
                int curW = j - i + 1;
                res = Math.max(res, curW * minHeight);
            }
        }
        return res;
    }
}
