package com.yanl.leetcode;

/**
 * @author YanL
 * @date 21:14 2020/9/15
 * 移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class L0283MoveZeros {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 0){
                count++;
            }else {
                nums[i-count] = nums[i];
            }
        }
        while (count > 0){
            nums[nums.length - count] = 0;
            count--;
        }
    }
}
