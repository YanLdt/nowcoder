package com.yanl.tiger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 16:52 2020/9/20
 * 完美洗牌问题
 * 数组顺序先 <=   后>=
 */
public class PerfectPoke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i ++){
            a[i] = sc.nextInt();
        }
        int right = n / 2;
        int left = n - right;
        Arrays.sort(a);
        for(int i = 0; i < right; i ++){
            System.out.print(a[i] + " " + a[left + i]);
        }
        if(left != right){
            System.out.print(a[left - 1]);
        }
    }
}
