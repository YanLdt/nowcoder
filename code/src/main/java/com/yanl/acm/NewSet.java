package com.yanl.acm;

/**
 * @author YanL
 * @date 21:43 2020/8/13
 * 集合 s 中有整数 1 到 n，牛牛想从中挑几个整数组成一个新的集合。
 * <p>
 * 现在牛妹给牛牛加了 m 个限制 ，每个限制包含两个整数 u 和 v (u,v不等)且 u 和 v 不能同时出现在新集合中 。
 * 请问牛牛能组成的新集合多少种。
 * 可以选 0 个数
 * 第一个参数为 n。
 * 第二个参数为 m。
 * 第三个参数为 m 对 (u, v) 。
 * 一个整数，即新集合的种类数。
 * <p>
 * 3,2,[(1,2),(2,3)]
 * 5
 * 当 n = 3 时，共有 8 个子集，当加上限制 (1, 2), (2, 3) 后，合法的自己有 [], [1], [2], [3], [1, 3] 共 5 个
 */
public class NewSet {
    public int solve(int n, int m, Point[] limit) {
        // write code here
        return -1;
    }
}

class Point {
    int x;
    int y;
}
