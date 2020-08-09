package com.yanl.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 使用hashMap来记录字符出现的次数，然后遍历字符数组，找到第一个map值为1的字符
 */
public class FirstNotRepeatingChar {

    public static int indexOfChar(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(Character c : chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c : chars){
            if(map.get(c) == 1){
                return str.indexOf(c);
            }
        }
        return -1;
    }
}
