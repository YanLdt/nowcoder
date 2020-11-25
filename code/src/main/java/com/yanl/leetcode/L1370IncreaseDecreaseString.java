package com.yanl.leetcode;

/**
 * @author YanL
 * @date 14:19 2020/11/25
 * L1370 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 使用桶计数计算每个字符出现的字数
 *
 */
public class L1370IncreaseDecreaseString {
    public String sortString(String s){
        StringBuilder sb = new StringBuilder();
        int[] chars = new int[26];
        //计数
        for(char c : s.toCharArray()){
            chars[c - 'a'] ++;
        }
        //遍历完之前
        while (sb.length() < s.length()){
            //从小到大遍历
            for(int i = 0; i < 26; i ++){
                if(chars[i] > 0){
                    sb.append((char)(i + 'a'));
                    chars[i] --;
                }
            }
            //然后从大到小遍历
            for(int i = 25; i >= 0; i --){
                if(chars[i] > 0){
                    sb.append((char)(i + 'a'));
                    chars[i] --;
                }
            }
        }
        return sb.toString();
    }
}
