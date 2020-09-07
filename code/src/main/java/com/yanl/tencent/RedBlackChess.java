package com.yanl.tencent;

import java.util.Scanner;

/**
 * @author YanL
 * @date 21:36 2020/9/6
 *
3
BRRBRB
2 3 1 1 2 3
5
交换相邻棋子，保证红黑分别有序，不考虑不同棋子的顺序
 */
public class RedBlackChess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] arr = new int[2*n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }


    }

}
