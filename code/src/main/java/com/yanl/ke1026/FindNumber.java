package com.yanl.ke1026;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author YanL
 * @date 19:30 2020/10/26
 */
public class FindNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextInt();
            long m = sc.nextInt();
            boolean flag = false;
            Set<Long> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                long a = sc.nextInt();
                set.add(a);
            }
            if(m == 0){
                if(set.contains(0)){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
            }else {
                for (long a : set) {
                    if (a != 0) {
                        if (m % a == 0) {
                            if (set.contains(m / a)) {
                                System.out.println("yes");
                                flag = true;
                                break;

                            }
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println("no");
            }
        }
    }
}
