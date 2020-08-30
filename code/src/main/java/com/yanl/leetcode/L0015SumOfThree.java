package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 给定一个包含n个整数的数组nums，判断数组中是否存在三个元素a,b,c,使得a+b+c = 0;
 * 请找出所有符合要求的三元组
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 记得去重
 */
public class L0015SumOfThree {
    public List<List<Integer>> threeSum(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < len-1 && nums[i] <= 0; i++){
            //这边是去重，如果前后两个数相等，求的解会重复
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int a = -nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                if(nums[left] + nums[right] == a){
//                    List<Integer> tmp = new ArrayList<>();
//                    tmp.add(i);
//                    tmp.add(left);
//                    tmp.add(right);
//                    res.add(tmp);
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //这边也是为了去重，因为三数之和已经为0了，所有后面的值再相等就重复了
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    //这边移动指针
                    left++;
                    right--;
                }else if(nums[left] + nums[right] > a){
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return res;
    }
}
