package com.yanl.six;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author YanL
 * @date 13:23 2020/8/27
 *
 */
public class MonotonicStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ins = new int[m];
        //原数组和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            stack.addFirst(tmp);
            sum += tmp;
        }
        for (int i = 0; i < m; i++) {
            ins[i] = sc.nextInt();
        }
        Arrays.sort(ins);
        //前k个数字的最大和
        int sumK = 0;
        for(int i = m - 1; i > m - k -1 ; i --){
            sumK += ins[i];

            while (!stack.isEmpty() && stack.peekFirst() <= ins[i]){
                sum -= stack.peek();
                stack.pop();
            }
            stack.push(ins[i]);
            sum += ins[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
