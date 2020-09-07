package com.yanl.ke0907;

import java.util.Scanner;

/**
 * @author YanL
 * @date 15:02 2020/9/7
 * 1.添加一个字符
 * 2.复制粘贴之前添加的所有字符且该方法只能使用一次
 */
public class StringBuild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        sc.close();
        char[] chars = s.toCharArray();

        char first = s.charAt(0);
        int left = 1;
        int max = 0;
        while (left <= n / 2){
            if(s.charAt(left) == first){
//                System.out.println(left);
//                System.out.println(s.substring(0, left));
//                System.out.println(s.substring(left , left + left ));
                if(s.substring(0, left).equals(s.substring(left , left + left ))){
                    max = Math.max(max, left);
                }
            }
            left++;
        }
//        System.out.println(max);
        if(max == 0){
            System.out.println(n);
        }else {
            System.out.println(1 + n - max);
        }
    }
}
