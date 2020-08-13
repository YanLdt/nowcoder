package com.yanl.bilibili;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YanL
 * @date 10:47 2020/8/13
 * 给定一个正整数N，试求有多少组连续正整数满足所有数字之和为N?
 * 5
 * 2
 * 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 */
public class ContinueNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if(n <= 2){
            System.out.println(1);
            return;
        }
        int i = 1;
        int j = 1;
        int sum = 0;
        int count = 0;
        //全部循环复杂度过大
        //可以遍历前半部分
        while (i <= n / 2){
            if(sum < n){
                sum+=j;
                j++;
            }else if(sum > n){
                sum -= i;
                i++;
            }else {
                count+=1;
                sum -= i;
                i++;
            }
        }
        System.out.println(count);
    }
}
