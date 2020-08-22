package com.yanl.nowcodermonth27;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:18 2020/8/22
 * 输入一个正整数 表示三个正实数的积
 * 输出三个数的最小和
 * 数学不等式 a+b >= 2根号a*b
 */
public class MinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double m = Math.pow(n, 1.0/3);
        System.out.println(String.format("%.3f",  3 * m));
    }
}
