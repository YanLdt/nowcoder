package com.yanl.shenxinfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:48 2020/8/25
 *
 */
public class ChangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int[] num = new int[10];
        for(int i = 0; i < 10; i ++){
            num[i] = i;
        }
        int n = sc.nextInt();
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            int[] tmp = new int[]{sc.nextInt(), sc.nextInt()};
            res.add(tmp);
        }
    }
}
