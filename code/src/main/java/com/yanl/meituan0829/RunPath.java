package com.yanl.meituan0829;

import java.util.Scanner;

/**
 * @author YanL
 * @date 16:31 2020/8/29
 * 小团惹小美生气了，小美要去找小团“讲道理”。小团望风而逃，
 * 他们住的地方可以抽象成一棵有n个结点的树，小美位于x位置，
 * 小团位于y位置。小团和小美每个单位时间内都可以选择不动或者向相邻的位置转移，
 * 假设小美足够聪明，很显然最终小团会无路可逃，只能延缓一下被“讲道理”的时间，
 * 请问最多经过多少个单位时间后，小团会被追上。
 *
 * 输入第一行包含三个整数n，x，y，分别表示树上的结点数量，小美所在的位置和小团所在的位置。(1<=n<=50000)
 * 接下来有n-1行，每行两个整数u，v，表示u号位置和v号位置之间有一条边，即u号位置和v号位置彼此相邻。
 * 输出仅包含一个整数，表示小美追上小团所需的时间。
 *
5 1 2
2 1
3 1
4 2
5 3
 *2
 */
public class RunPath {
    static int[] p = new int[50010];

    public static int find(int x){
        if(p[x] != x){
            p[x] = find(p[p[x]]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        StringBuilder[] result = new StringBuilder[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = new StringBuilder("");
        }
        for(int i = 0; i < n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a != b){
                int pa = find(a);
                int pb = find(b);
                if(pa > pb){
                    p[pa] = pb;
                }else {
                    p[pb] = pa;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            //pi是第i个的根节点
            int pi = find(i);
            //然后需要把pi开头的序列保存起来
            result[pi].append(i);
        }
        for(int i = 1; i <= n; i++){
            if(p[i] == i){
                char[] chars = result[i].toString().toCharArray();
                System.out.println(2);
            }
        }
    }
}
