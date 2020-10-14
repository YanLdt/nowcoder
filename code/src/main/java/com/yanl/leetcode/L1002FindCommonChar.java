package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YanL
 * @date 17:00 2020/10/14
 * 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 计数吧  全是小写字母，就记录下26个字母出现的频率最小值得出就完事了
 * 最后再打印出最小频率个数个字母
 *
 */
public class L1002FindCommonChar {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null){
            return res;
        }
        int[] minFre = new int[26];
        Arrays.fill(minFre, Integer.MAX_VALUE);
        for(String s : A){
            int[] fre = new int[26];
            int len = s.length();
            for(int i = 0; i < len; i ++){
                char c = s.charAt(i);
                fre[c - 'a'] ++;
            }
            for(int i = 0; i < 26; i ++){
                minFre[i] = Math.min(fre[i], minFre[i]);
            }
        }

        for(int i = 0; i < 26; i ++){
            for(int j = 0; j < minFre[i]; j ++){
                res.add(String.valueOf((char)(i + 'a')));
            }
        }
        return res;
    }
}
