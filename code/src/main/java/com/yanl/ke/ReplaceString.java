package com.yanl.ke;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:10 2020/8/11
 *
 */
public class ReplaceString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(new ReplaceString().count(s, len));
    }

    public int count(String str, int len){
        int left = 0;
        int right = len - 1;
        int res = 0;
        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                res++;
            }
            left++;
            right--;
        }
        return res;
    }
}
