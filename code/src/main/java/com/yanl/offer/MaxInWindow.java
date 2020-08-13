package com.yanl.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YanL
 * @date 17:03 2020/8/13
 * 给定一个数组和滑动窗口的大小，
 * 找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 */
public class MaxInWindow {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if(size > len || size == 0){
            return res;
        }
        int i = 0;
        int j = i + size;
        while (j < len-1){
            int[] tmp = Arrays.copyOfRange(num, i, j);
            res.add(findMax(tmp));
            i++;j++;
        }
        return res;
    }

    public int findMax(int[] num){
        int max = 0;
        for(int n : num){
            if(max < n){
                max = n;
            }
        }
        return max;
    }
}
