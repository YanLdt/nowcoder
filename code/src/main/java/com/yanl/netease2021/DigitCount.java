package com.yanl.netease2021;

import java.util.Scanner;

/**
 * @author YanL
 * @date 15:01 2020/8/8
 * 牛牛现在有一个包含 n 个正整数的数组 a ，
 * 牛牛可以将其中的每个数 a[i] 都拆成若干个和为 a[i] 的正整数，
 * 牛牛想知道拆后（也可以一个数都不拆）这个数组最多能有多少个素数。
 */
public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long res = 0;
        for (int i = 0; i < n; i++) {
            long number = sc.nextInt();
            res += (number / 2);
        }
        System.out.println(res);
    }
}
