package com.yanl.leetcode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 */
public class L0031NextPermutation {
    public void nextPermutation(int[] nums){
        int len = nums.length;
        boolean flag = false;
        for (int i = len - 2; i >= 0; i--) {
            //首先在右边找到第一个num[i] < nums[i+1]的情况
            if(nums[i+1] > nums[i]){
                int j = len - 1;
                flag = true;
                while (nums[i] >= nums[j]){
                    j--;
                }
                //将nums[i]与[i+1, len - 1]之间最小的大于nums[i]的数交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                int left = i;
                int right = len - 1;
                //最后将[i+1, len-1]反转
                while (left < right){
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right--;
                }
            }
        }
        //如果找不到nums[i]<nums[i+1]，则数组为最大，直接排序输出
        if(!flag){
            Arrays.sort(nums);
        }
    }
}
