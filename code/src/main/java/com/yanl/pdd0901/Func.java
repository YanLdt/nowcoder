package com.yanl.pdd0901;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author YanL
 * @date 19:58 2020/9/1
 *
 */
public class Func {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = sc.nextInt();
        int[] nums = new int[number];
        for (int i = 0; i < number; i++) {
            nums[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < number ; i ++){
            for(int j = nums[i]; j <= n; j++){
                if(j % nums[i] == 0){
                    set.add(j);
                }
            }
        }
        System.out.println(set.size());
    }
}
