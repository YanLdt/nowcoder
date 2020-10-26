package com.yanl.ke1026;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:11 2020/10/26
 */
public class ThreeMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if(x != y && x != z && y != z){
                System.out.println("NO");
                continue;
            }
            int[] tmp = new int[3];
            tmp[0] = x;
            tmp[1] = y;
            tmp[2] = z;
            Arrays.sort(tmp);
            if(tmp[1] != tmp[2]){
                System.out.println("NO");
            }else {
                if(tmp[0] > tmp[2]){
                    System.out.println("NO");
                }else {
                    System.out.println("YES");
                    System.out.println(tmp[2] + " " + tmp[0] + " " + tmp[0]);
                }
            }
        }
    }
}
