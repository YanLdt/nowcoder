package com.yanl.kingsoft;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:47 2020/9/23
 */
public class CountOf5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 1; i <= n; i ++){
            int num = i;
            while (num > 0){
                if(num % 10 == 5){
                    res++;
                }
                num /= 10;
            }
        }
        System.out.println(res);
    }
}
