package com.yanl.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YanL
 * @date 0:25 2020/8/30
 * 接雨水
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的这个柱子，下雨之后能接多少雨水
 *
 */
public class L0042TrapWater {
    public int trap(int[] height){
        if(height == null){
            return 0;
        }
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int res = 0;
        //从左到右的最大值和从右到左的最大值
        int leftMax = 0, rightMax = 0;
        while (left < right){
            //积水高度由较低的那一块决定
            //如果左侧小于右侧的话，则当前块就能知道他所能存储的水量，大于右侧的话无法确定当前块所能存储的水量
            //因此要从右面算起
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else {
                    res += leftMax - height[left];
                }
                left++;
            }else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
