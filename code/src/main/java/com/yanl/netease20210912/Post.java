package com.yanl.netease20210912;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author YanL
 * @date 16:07 2020/9/12
 */
public class Post {

    static int N = 1010;
    static int[] p = new int[N];
    public static int find(int x){
        if(p[x] != x){
            p[x] = find(p[p[x]]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n-1][2];
        for(int i = 0; i < n - 1; i ++){
            int a = sc.nextInt();
            arr[i] = new int[]{a, i+1};
        }
        for(int i = 0; i < n-1; i ++){
            int a = arr[i][0];
            int b = arr[i][1];
            if(a != b){
                int pa = find(a);
                int pb = find(b);
                //要求从小输出，所以以小的数字为父节点
                if(pa < pb){
                    p[pb] = pa;
                }else {
                    p[pa] = pb;
                }
            }
        }
        StringBuilder[] result = new StringBuilder[n+1];
        for (int i = 0; i < n-1; i++) {
            result[i] = new StringBuilder("");
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n - 1; i ++){
            int pi = find(i);
            result[pi].append(i);
        }
        if(k > result[0].length()){
            System.out.println(result[0].length());
        }else {
            System.out.println(k+1);
        }
    }
}
