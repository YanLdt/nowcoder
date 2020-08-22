package com.yanl.nowcodermonth27;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:00 2020/8/22
 * 调查兵团第56次壁外调查将对巨木之森展开，已知巨木之森共有n块区域和n-1条道路，
 * 保证这n块区域联通。为了调查结果尽可能准确，兵团会派遣若干支小分队调查巨木之森，派出的小分队需满足以下规定：
 * 1.每支小分队都可以选择从任意一块区域出发，但各支小分队的出发区域必须互不相同。
 * 2.每支小分队都必须遍历完n块区域。
 * 3.每支小分队的物资消耗量为其遍历完n块区域的路程和。
 * 现已知调查兵团的物资总量为m，请问最多能派遣多少支小分队参与调查？
 * 第一行 n,m表示巨木之森的区域数和调查兵团的物资总量
 * 接下来n-1行，每行三个正整数u,v,w，代表u号区域和v号区域之间有一条长w的道路
 * 输出最多能派遣的小分队数量
 *
3 6
1 2 1
2 3 1
 * 2
 * 从1号区域出发，遍历完3块区域，物资消耗量最少为2。
 * 从2号区域出发，遍历完3块区域，物资消耗量最少为3。
 * 从3号区域出发，遍历完3块区域，物资消耗量最少为2。
 * 故最多派遣2支小分队。
 */
public class NumberOfArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<long[]> paths = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            long[] tmp = new long[3];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            tmp[2] = sc.nextInt();
            paths.add(tmp);
        }
    }
}
