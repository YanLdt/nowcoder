package com.yanl.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author YanL
 * @date 23:28 2020/9/18
 */
public class L0215KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        //默认小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i : nums){
            queue.offer(i);
        }
        for(int i = 0; i < k - 1; i ++){
            queue.poll();
        }
        return queue.peek();
    }

    static Random random = new Random(System.currentTimeMillis());

    public int find(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int tar = len - k;
        while (true){
            int index = partition(nums, left, right);
            if(index == tar){
                return nums[index];
            }else if(index < tar){
                left = index + 1;
            }else {
                right = index - 1;
            }
        }
    }
    public int partition(int[] nums, int left, int right){
        if(left < right){
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int tmp = nums[left];

        int l = left + 1;
        int r = right;
        while (true){
            while (l <= r && nums[l] < tmp){
                l++;
            }
            while (l <= r && nums[r] > tmp){
                r--;
            }
            if(l > r){
                break;
            }
            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, r, left);
        return r;
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
