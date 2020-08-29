package com.yanl.leetcode;

/**
 * @author YanL
 * @date 0:15 2020/8/30
 * 盛水最多的容器
 * 给n个非负整数，每个数代表坐标中的一个点，在坐标内花n条垂直线，垂直线i的两个端点分别为（i，0）（i，ai）
 * 找出其中的两条线，使得他们与x轴共同组成的容器可以容纳最多的水
 */
public class L0011ContainerWithMostWater {
    public int maxArea(int[] height){
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int res = 0;
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
