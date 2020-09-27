package com.yanl;

import java.util.Scanner;

/**
 * @author YanL
 * @date 23:15 2020/9/27
 */
public class ComputeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double in = sc.nextDouble();
        int n = sc.nextInt();
        sc.close();
        System.out.println("郁亚凯的月收入为" + in / n + "元");
    }
}
