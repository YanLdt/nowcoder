package com.yanl.wei;

import java.util.Scanner;

/**
 * @author YanL
 * @date 10:43 2020/10/11
 */
public class MeiTuan01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                int temp = sc.nextInt();
                min = Math.min(min, temp);
                max = Math.max(max, temp);
                if (temp < a || temp > b) {
                    break;
                }
            }
            if (min > a && max < b && n - m >= 2) {
                System.out.println("YES");
            } else if (min == a && max == b) {
                System.out.println("YES");
            } else if ((min == a || max == b) && (n - m >= 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            sc.nextLine();
        }
    }
}
