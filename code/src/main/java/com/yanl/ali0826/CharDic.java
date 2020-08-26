package com.yanl.ali0826;

import java.util.Scanner;

/**
 * @author YanL
 * @date 9:17 2020/8/26
 * 给定长度为n的两个字符串A B，字典序小于B但是大于A且长度等于n的单词有多少个
 4
 1 z a
 1 a z
 2 az bb
 3 bbb bbb
 */
public class CharDic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++){
            int len = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            long l1 = strTo26(s1);
            long l2 = strTo26(s2);
            if(l1 >= l2){
                System.out.println(0);
            }else {
                System.out.println(l2 - l1);
            }
        }
    }

    /**
     * 字符串转26进制
     * @param str
     * @return
     */
    public static long strTo26(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            sb.append(Integer.toString(c, 26));
        }
        return Long.parseLong(sb.toString());
    }
}
