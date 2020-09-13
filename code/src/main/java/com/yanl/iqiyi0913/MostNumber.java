package com.yanl.iqiyi0913;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 15:37 2020/9/13
 * 多数元素
 */
public class MostNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        sc.close();
        int[] arr = new int[s.length];
        for(int i = 0; i < s.length; i ++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length / 2]);
    }
}
