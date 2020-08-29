package com.yanl.meituan0829;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 17:38 2020/8/29
 * 小团是一个莫得感情的CtrlCV大师，他有一个下标从1开始的序列A和一个初始全部为-1的序列B，两个序列的长度都是n。他会进行若干次操作，每一次操作，他都会选择A序列中一段连续区间，将其粘贴到B序列中的某一个连续的位置，在这个过程中他也会查询B序列中某一个位置上的值。
 *
 * 我们用如下的方式表示他的粘贴操作和查询操作：
 *
 * 粘贴操作：1  k x y，表示把A序列中从下标x位置开始的连续k个元素粘贴到B序列中从下标y开始的连续k个位置上，原始序列中对应的元素被覆盖。（数据保证不会出现粘贴后k个元素超出B序列原有长度的情况）
 *
 * 查询操作：2 x，表示询问当前B序列下标x处的值是多少。
 *
 *
 */
public class CtrlCV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
            b[i] = -1;
        }
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            if("1".equals(arr[0])){
                int start = Integer.parseInt(arr[2]);
                int end = Integer.parseInt(arr[2]) + Integer.parseInt(arr[1]) - 1;
                int bStart = Integer.parseInt(arr[3]);
                for(int tmp = start; tmp <= end; tmp++){
                    b[bStart-1] = a[tmp-1];
                    bStart++;
                }
            }else {
                System.out.println(b[Integer.parseInt(arr[1])-1]);
            }
        }
    }
}
