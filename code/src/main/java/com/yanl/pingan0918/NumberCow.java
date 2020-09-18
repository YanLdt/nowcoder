package com.yanl.pingan0918;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:30 2020/9/18
 */
public class NumberCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(cow(n));
    }

    public static int cow(int n){
        if(n <= 3){
            return n;
        }else {
            return cow(n-1) + cow(n-3);
        }
    }
}
