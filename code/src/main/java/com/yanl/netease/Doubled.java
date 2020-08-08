package com.yanl.netease;

import java.util.Scanner;

/**
 * @author YanL
 * @date 13:36 2020/8/8
 * ABpq,每次操作A = A+P 或者 p = p * q
 * 使B <= A的最小操作
 *
 * 输出描述:
 * 对于每组数据，输出一个数字表示答案
 * 输入例子1:
 * 2
 * 1 5 7 2
 * 3 5 1 2
 * 输出例子1:
 * 1
 * 2
 * 输入例子2:
 * 2
 * 1 15 4 2
 * 12 19 3 2
 * 输出例子2:
 * 3
 * 3
 * */
public class Doubled {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            System.out.println(doubled(A, B, p, q, 0));
        }
    }

    public static int doubled(int A, int B, int p, int q, int count){
        if(B - A <= p){
            return count + 1;
        }else if((B - A) / p <= q){
            return count + 2;
        }
        else {
            return doubled(A, B, p, q, count);
        }
    }
}
