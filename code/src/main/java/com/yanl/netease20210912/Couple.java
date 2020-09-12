package com.yanl.netease20210912;

import java.util.Scanner;
import java.util.Set;

/**
 * @author YanL
 * @date 16:31 2020/9/12
 */
public class Couple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        int n = sc.nextInt();
        int[][] couple = new int[n][2];
        for(int i = 0; i < n; i ++){
            couple[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        int[] male = new int[arr1.length];
        int[] female = new int[arr2.length];
        for(int i = 0; i < arr1.length; i ++){
            male[i] = Integer.parseInt(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i ++){
            female[i] = Integer.parseInt(arr2[i]);
        }
        System.out.println(male.length);
    }
}
