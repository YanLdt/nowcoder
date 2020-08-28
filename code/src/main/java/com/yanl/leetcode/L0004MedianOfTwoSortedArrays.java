package com.yanl.leetcode;

/**
 * @author YanL
 * @date 23:43 2020/8/28
 * 寻找两个正序数组的中位数
 * 给定两个大小为m和n的正序数组
 * 找出两个正序数组的中位数
 * O(log(m+n))
 */
public class L0004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left)
                + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 查找两个数组的第k个元素
     * 递归出口是 k = 1或者任意一个数组为0
     * @param nums1
     * @param index1 nums1的初始位置
     * @param nums2
     * @param index2 nums2的初始位置
     * @return
     */
    public static int findKth(int[] nums1, int index1, int[] nums2, int index2, int k){
        if(index1 >= nums1.length){
            //num1为空数组直接返回nums2第k个元素
            return nums2[index2 + k - 1];
        }
        if(index2 >= nums2.length){
            //num2为空数组直接返回nums1第k个元素
            return nums1[index1 + k - 1];
        }
        if(k == 1){
            //k = 1 时返回较小值
            return Math.min(nums1[index1], nums2[index2]);
        }
        //两个数组的当前指针位置
        int cur1 = index1 + Math.min(nums1.length, k / 2) - 1;
        int cur2 = index2 + Math.min(nums2.length, k / 2) - 1;
        if(nums1[cur1] > nums2[cur2]){
            //nums1[cur1] > nums2[cur2]，这时删去nums2的前k/2个数，继续递归
            return findKth(nums1, index1, nums2, cur2 + 1, k - (cur2 - index2 + 1));
        }else {
            //否则就删除nums1的前k/2个数
            return findKth(nums1, cur1 + 1, nums2, index2, k - (cur1 - index1 + 1));
        }
    }
}
