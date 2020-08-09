package com.yanl.netease2021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 15:43 2020/8/8
 * 现在有n个物品，每一个物品都有一个价值，现在想将这些物品分给两个人，
 * 要求这两个人每一个人分到的物品的价值总和相同（个数可以不同，总价值相同即可），
 * 剩下的物品就需要扔掉，现在想知道最少需要扔多少价值的物品才能满足要求分给两个人。
 *
 * 1
 * 5
 * 30 60 5 15 30
 * 20
 * 样例解释，扔掉第三个和第四个物品，然后将第一个物品和第五个物品给第一个人，第二个物品给第二个人，
 * 每一个人分到的价值为6060，扔掉的价值为2020。
 *
 * 直接暴力dfs
 */
public class Divide {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            int[] arr = new int[num];
            for(int j = 0; j < num; j++){
                arr[i] = sc.nextInt();
            }
        }
    }

}

/*
1
5
30 60 5 15 30

20
 */
