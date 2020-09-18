package com.yanl.pingan0918;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:24 2020/9/18
 */
public class Max3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ab = a + b;
        int ac = a + c;
        int bc = b + c;
        if(max3(a, bc, c) + max3(a, b, bc) == 0){
            System.out.println("ERROR");
        }else {
            double res = ((double) max3(ab, b, c)) / ((double)(max3(a, bc, c) + (double)max3(a, b, bc)));
            System.out.println(String.format("%2f", res));
        }

    }

    public static int max3(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
}
