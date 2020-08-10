package com.yanl.offer;

import java.util.ArrayList;

/**
 * @author YanL
 * @date 13:02 2020/8/10
 * 输入一个正整数 sum ，输出所有和为 sum 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 使用滑动窗口解题，维护左右两个端点，
 * 如果小于sum则右边界+1
 * 大于sum则左边界+1，同时需要将tmp减去左边界的值
 * 等于则将[left, right)加入结果集
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        int left = 1;
        int right = 1;
        int tmpSum = 0;
        int end = sum / 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (left <= end){
            if(tmpSum < sum){
                tmpSum += right;
                right++;
            }else if(tmpSum > sum){
                tmpSum -= left;
                left++;
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = left; i < right; i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                tmpSum -= left;
                left++;
            }
        }
        return res;
    }
}
