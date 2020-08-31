package com.yanl.leetcode;

/**
 * @author YanL
 * @date 16:48 2020/8/31
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 不能使用代码库中的排序函数来解决这道题。
 */
public class L0075SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if (num == 0) {
                num0++;
            }
            if (num == 1) {
                num1++;
            }
            if (num == 2) {
                num2++;
            }
        }
        for(int i = 0; i < len; i ++){
            if(num0 != 0){
                nums[i] = 0;
                num0--;
            }else if(num1 != 0){
                nums[i] = 1;
                num1--;
            }else if(num2 != 0){
                nums[i] = 2;
                num2--;
            }
        }
    }

    /**
     * 一次遍历分为三个区间 0-zero为0   two - len-1为2  中间部分为1
     * @param nums
     */
    public void partition(int[] nums){
        int len = nums.length;
        //-1保证nums[0]=0;
        int zero = -1;
        int two = len - 1;
        int i = 0;
        while (i <= two){
            if(nums[i] == 0){
                zero++;
                swap(nums, i, zero);
                i++;
            }else if(nums[i] == 1){
                i++;
            }else {
                swap(nums, i, two);
                two--;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
