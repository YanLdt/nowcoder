package com.yanl.nowcodermonth27;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:18 2020/8/22
 * n位乐手，乐手的能力值为ai,表示该乐手所在乐队人数必须大于等于ai,在保证每个乐手都被分进一个乐队的情况下
 * 乐队数量最多可以是多少
4
2 1 2 1
 * 3  ===> 1 1 22
 */
public class Band {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
    }
}
