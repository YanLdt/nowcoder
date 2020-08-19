package com.yanl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YanL
 * @date 0:46 2020/8/20
 * 给定一个字符串，找到没有重复字符的最长子串，返回它的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class L003LongestSubStringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s){
        if(s == null){
            return 0;
        }
        int len = s.length();
        //存储字符和对应的字符位置
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int left = 0, right = 0; right < len; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                //如果map中存在该字符，则将left置为字符位置+1，接着遍历字符串
                //保证left不会左移
                left = Math.max(map.get(c) + 1, left);
            }
            //更新最长子序列的长度
            res = Math.max(res, right - left + 1);
            //对之前一个字符位置的更新
            map.put(s.charAt(right), right);
        }
        return res;
    }
}
