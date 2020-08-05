package com.yanl.pdd2020;

import java.util.*;

/**
 * @Author: YanL
 * @Time: 17:10 2020/8/2
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 在一块长为n，宽为m的场地上，有n✖️m个1✖️1的单元格。每个单元格上的数字就是按照从1到n和1到m中的数的乘积。具体如下
 *
 * n = 3, m = 3
 * 1   2   3
 * 2   4   6
 * 3   6   9
 *
 * 给出一个查询的值k，求出按照这个方式列举的的数中第k大的值v。
 * 例如上面的例子里，
 * 从大到小为(9, 6, 6, 4, 3, 3, 2, 2, 1)
 * k = 1, v = 9
 * k = 2, v = 6
 * k = 3, v = 6
 * ...
 * k = 8, v = 2
 * k = 9, v = 1
 *
 * 输入描述:
 * 只有一行是3个数n, m, k 表示场地的宽高和需要查询的k。使用空格隔开。
 *
 * 输出描述:
 * 给出第k大的数的值。
 *
 * 输入例子1:
 * 3 3 4
 *
 * 输出例子1:
 * 4
 */
public class TwoDimensionMaxK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][m];
        //从后往前数要找的位置
        int postK = m * n - k + 1;
        int low = 1;
        int high = m * n;
        while(low < high){
            int middle = (high + low) / 2;
            int curRow = middle / n;
            int curCol = middle / m;
            //当前个数
            int count = curRow * n + curCol * (n - curRow);
            for(int i = curRow + 1; i < n; i++){
                for(int j = curCol + 1; j < m; j++){

                }
            }
        }

        compute(arr, n, m);
        System.out.println(Arrays.toString(arr));
        System.out.println(getK(arr, n ,m, k));
    }

    private static void compute(int[][] arr, int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = (i+1)*(j+1);
            }
        }
    }

    private static int getK(int[][] arr, int n, int m, int k){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res.add(arr[i][j]);
            }
        }
        System.out.println(res.toString());
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(res.toString());
        return res.get(k-1);
    }
}
