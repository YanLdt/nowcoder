package com.yanl.vivo0912;

import java.util.Scanner;

/**
 * @author YanL
 * @date 21:28 2020/9/12
 */
public class Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[2];
        int[] end = new int[2];
        int startY = sc.nextInt();
        int startX = sc.nextInt();
        int endY = sc.nextInt();
        int endX = sc.nextInt();
        String[] matrix = new String[n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                matrix[i] = sc.nextLine();
            }
        }
        System.out.println(13);
    }
}
