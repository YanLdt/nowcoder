package com.yanl.ke1026;

import java.util.*;

/**
 * @author YanL
 * @date 19:41 2020/10/26
 */
public class NearNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(count(l, r));
        }
    }

    public static int count(int left, int right){
        int res = 0;
        while(left <= right){
            String tmp = String.valueOf(left);
            char[] chars = tmp.toCharArray();
            Arrays.sort(chars);
            int a = Integer.parseInt(String.valueOf(chars[0]));
            int b = Integer.parseInt(String.valueOf(chars[chars.length - 1]));
            if(b <= 2 * a){
                res ++;
            }
            left ++;
        }
        return res;
    }
}
