package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YanL
 * @date 23:46 2020/8/30
 * 电话号码的字母组合
 * 给定一个仅包含2-9的字符串，返回所有它能表示的字母组合
 * 2-abc
 * 3-def
 * 4-ghi
 * 5-jkl
 * 6-mno
 * 7-pqrs
 * 8-tuv
 * 9-wxyz
 * 简单回溯算法
 */
public class L0017LetterCombinations {
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(digits, res, 0, new StringBuilder(), map);
        return res;
    }

    /**
     * 回溯算法
     * @param digits
     * @param res
     * @param index
     * @param sb
     * @param map
     */
    public void backTrack(String digits, List<String> res, int index, StringBuilder sb, Map<Character, String> map){
        //遍历完所有字符把字符串加入到结果集
        if(index == digits.length()){
            res.add(sb.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int len = letters.length();
            for (int i = 0; i < len; i++) {
                //回溯 -- 先操作当前数字所代表的第一个字母，然后继续处理下一个数字，
                // 直到遍历完所有数字再回溯操作当前数字代表的第二个字母
                sb.append(letters.charAt(i));
                backTrack(digits, res, index + 1, sb, map);
                sb.deleteCharAt(index);
            }
        }
    }
}
