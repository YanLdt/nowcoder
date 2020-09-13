package com.yanl.iqiyi0913;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author YanL
 * @date 15:29 2020/9/13
 * 最长不重复子串
 */
public class LongestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int left = 0, right = 0; right < len; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(map.get(c) + 1, left);
            }
            res = Math.max(res, right - left + 1);
            map.put(c, right);
        }
        System.out.println(res);
    }
}
