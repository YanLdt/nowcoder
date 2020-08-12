package com.yanl.bilibili;

import java.util.Scanner;

/**
 * @author YanL
 * @date 21:45 2020/8/12
 * 原地翻转句子中单词的顺序，但单词内字符的顺序不变。要求：空间复杂度O(1)，时间复杂度O(n)。
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.trim().split(" ");
        int len = strs.length;
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1; i >= 0; i--){
            if(" ".equals(strs[i])){
                continue;
            }
            sb.append(strs[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
