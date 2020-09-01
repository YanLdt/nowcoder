package com.yanl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YanL
 * @date 17:08 2020/8/31
 * 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，
 * 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 滑动窗口解题，使用一个数组来存储是否已经匹配完全整个字符串
 */
public class L0076MinimumWindowSubString {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[] dic = new int[128];
        //记录T中所有字符出现的频率
        for(char c : t.toCharArray()){
            dic[c]++;
        }
        int left = 0;
        int right = 0;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (right < lenS){
            char c = s.charAt(right);
            //如果C存在于T中，此时dic[c]应该-1.说明匹配了一个
            //如果C不存在于T中，则dic[c]<0
            dic[c]--;
            if(dic[c] >= 0){
                match++;
            }
            //移动窗口右边界
            right++;
            //匹配成功后，缩小左边界
            while (match == lenT){
                int len = right - left;
                if(len < minLen){
                    minLen = len;
                    start = left;
                    end = right;
                }
                //左边的字符
                char cL = s.charAt(left);
                //左边的字符如果不在T中的话则移除窗口应该是做++操作，最大值也就是0
                //如果左边字符在T中，做了++操作应该大于0；如果移除的话将不满足要求，因此match--,需要再次匹配
                dic[cL]++;
                if(dic[cL] > 0){
                    match--;
                }
                left++;
            }
        }
        return s.substring(start, end);
    }
}
