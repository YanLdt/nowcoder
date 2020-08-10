package com.yanl.offer;

import java.util.Arrays;

/**
 * @author YanL
 * @date 21:42 2020/8/10
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
public class DuplicateNumber {
    public boolean duplicate(int[] nums, int length, int[] duplication){
        if(length == 0 || nums == null){
            return false;
        }
        Arrays.sort(nums);
        int i, j = 0;
        for(i = 0; i < length-1; i++){
            j = i+1;
            if(nums[i] == nums[j]){
                duplication[0] = nums[i];
                return true;
            }else{
                i = j;
            }
        }
        return false;
    }

    /**
     * 利用1----n-1
     * 将i与nums[i]互换--如果出现 arr[i]=arr[arr[i]]-->arr[i]这个值应该在arr[i]这个位置上
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicateV2(int[] nums, int length, int[] duplication){
        if(length == 0 || nums == null){
            return false;
        }
        for(int i = 0; i < length; i++){
            while (i != nums[i]){
                if(nums[i] == nums[nums[i]]){
                    duplication[0] = nums[i];
                    return true;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return false;

    }

}
