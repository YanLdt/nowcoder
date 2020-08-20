package com.yanl.sf;

import java.util.*;

/**
 * @author YanL
 * @date 20:24 2020/8/20
 * 小A的购买了一批服务器，他准备将这些服务器租用出去。每一个服务器有一个固定的带宽，
 * 人们根据自己需要的带宽来租用这些服务器。一台服务器只能租给一个人。
 * 小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。有m个客户来租服务器，
 * 第 i 位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。（服务器带宽独立不可叠加，若不能成功租出则输出0）
 * 小A可以选择拒绝一些人，现在，小A想知道自己的服务器最多能租多少钱？
 *
 * 输入第一行包含两个数n,m
 *
 * 接下来1行n个数，第i个数ai代表第 i 个服务器的带宽大小。
 *
 * 接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算。
 *
 * n,m≤1000 , 1≤ai,bi,ci≤1000
 *
 * 输出一个数，即小A最多能租多少元的服务器出去。
 *
3 4
1 2 3
2 1
3 2
3 3
1 1
 * 5
 * 样例解释
 * 1号服务器租给4号客户
 * 2号服务器租给1号客户
 * 3号服务器租给3号客户
 */
public class ServerMange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        int[] server = new int[n];
        ArrayList<Integer> server = new ArrayList<>();
        ArrayList<int[]> cus = new ArrayList<>();
        for(int i = 0; i < n; i++){
            server.add(sc.nextInt());
        }
        for(int i = 0; i < m; i++){
            int[] tmp = new int[2];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            cus.add(tmp);
        }
        Collections.reverse(server);
        cus.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
//        for(int i : server){
//            System.out.println(i);
//        }
//        for(int[] a : cus){
//            System.out.println(Arrays.toString(a));
//        }
        if(server.get(0) < cus.get(cus.size()-1)[0]){
            System.out.println(0);
            return;
        }

        long res = 0;
        for(int s : server){
            for(int[] a: cus){
                if(a[0] <= s){
                    res+=a[1];
                    cus.remove(a);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
