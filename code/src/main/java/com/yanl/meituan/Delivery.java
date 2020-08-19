package com.yanl.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author YanL
 * @date 14:58 2020/8/19
 * 小团是美团外卖的区域配送负责人，众所周知，外卖小哥一般都会同时配送若干单，
 * 小团在接单时希望把同一个小区的单子放在一起，然后由一名骑手统一配送。
 * 但是由于订单是叠在一起的，所以，他归类订单时只能知道新订单和已有的某个订单的小区是相同的，
 * 他觉得这样太麻烦了，所以希望你帮他写一个程序解决这个问题。
 * 即给出若干个形如ab的关系，表示a号订单和b号订单是同一个小区的，
 * 请你把同一个小区的订单按照编号顺序排序，并分行输出，优先输出最小的订单号较小的小区订单集合。
 * 订单的编号是1到n。（可能存在同时出现ab和ba这样的关系，也有可能出现aa这样的关系）
 *
 * 输入第一行是两个正整数n、m，表示接受的订单数量和已知的关系数量。（1≤n,m≤100001≤n,m≤10000）
 * 接下来有m行，每行两个正整数a和b，表示a号订单和b号订单属于同一个小区（1≤a,b≤n1≤a,b≤n）
 * 输出第一行包含一个整数x，表示这些订单共来自x个不同的小区。
 * 接下来的输出包含x行，每行表示输出若干个订单编号，表示这些订单属于同一个小区，
 * 按照订单编号升序输出。优先输出最小的订单编号较小的小区。
7 6
1 2
2 2
3 1
4 2
5 4
6 7
 *
 * 1
 * 1 2 3 4 5
 *
 * 使用并查集做，首先先初始化一个数组，
 * 然后遍历各个集合，查找各个点的祖先节点，存入数组
 * 最后遍历数组，如果p[i] = i则说明是祖先节点。
 */
public class Delivery {

    static int N = 10010;
    static int[] p = new int[N];
    /**
     * 查找x的祖先
     * @param x 当前元素
     * @return 返回祖先
     */
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
        //初始化数组
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        StringBuilder[] result = new StringBuilder[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = new StringBuilder("");
        }
        //这里合并各个集合，将大数指向小数
        for(int i = 0; i < m; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
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
        int res = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        //遍历一遍数组，如果p[i] = i，则说明是根节点 结果+1；并将改点的子节点加入结果集
        for(int i = 1; i <= n; i++){
            if(p[i] == i){
                res++;
            }
            //pi是第i个的根节点
            int pi = find(i);
            //然后需要把pi开头的序列保存起来
            result[pi].append(i);
        }
        System.out.println(res);
        for(int i = 1; i <= n; i++){
            if(p[i] == i){
                for(char c : result[i].toString().toCharArray()){
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        }
    }
}
