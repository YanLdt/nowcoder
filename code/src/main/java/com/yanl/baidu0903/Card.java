package com.yanl.baidu0903;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:48 2020/9/3
 * n张卡片，每张是0/5，选出若干卡片组成一些数字，找出所有可能的数字中能整除90的最大数字，不存在输出-1；
11
5 5 5 5 5 5 5 5 0 5 5
5555555550
 */
public class Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int number5 = 0;
        int number0 = 0;
        for(int i = 0; i < n; i ++){
            int tmp = sc.nextInt();
            if(tmp == 5){
                number5++;
            }
            if(tmp == 0){
                number0++;
            }
            sum += tmp;
            arr[i] = tmp;
        }
        sc.close();
        if(number0 == 0){
            System.out.println("-1");
            return;
        }
        while (number5>0){
            if(sum % 9 != 0){
                sum -=5;
                number5--;
            }else {
                break;
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else {
            for(int i = 0; i < number5; i ++){
                System.out.print("5");
            }
            for (int i = 0; i < number0; i++) {
                System.out.print("0");
            }
        }
    }
}
