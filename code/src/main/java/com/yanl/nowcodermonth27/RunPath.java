package com.yanl.nowcodermonth27;

import java.util.Scanner;

/**
 * @author YanL
 * @date 23:49 2020/8/22
 * 逃跑路线，
 * 第一行n，代表跑了多少次
 * 接下来N行，每行一个正整数a[i],但是
 * 判断最终距离与1的相与结果---->
 * a[i]是小于10的10000次方，所以不能直接加起来，可以计算最终结果的个位数是奇数还是偶数，奇数相与为0，偶数相与为1
 */
public class RunPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            String s = sc.next();
            sum += s.charAt(s.length() - 1) - '0';
        }
        System.out.println(sum & 1);
    }
}
