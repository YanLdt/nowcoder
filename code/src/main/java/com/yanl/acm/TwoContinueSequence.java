package com.yanl.acm;

import java.util.Scanner;

/**
 * @author YanL
 * @date 14:59 2020/8/18
 * 给一个整数序列，求两个不同的连续子序列的最大和
 */
public class TwoContinueSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            int res = findMax(arr, len);
            System.out.println(res);
        }
    }


    /*
    1
    5
    -1 -2 -3 -4 -5
     */

    /**
     * 暴力枚举
     * 将数组分成前后两个部分
     * 使用动态规划使用两个数组来保存前后两个部分的子序列最大值
     * 然后遍历数组求得最大值
     *
     * @param arr
     * @param len
     * @return
     */
    public static int findMax(int[] arr, int len) {
        //tmpL是以i结尾的序列的最大值
        //tmpR是以i开头的序列的最大值
        //lSum是i前面的连续子序列的最大值，不一定以i结尾
        //rSum是i后面的连续子序列的最大值，不一定以i开头
        int[] tmpL = new int[len];
        int[] tmpR = new int[len];
        int[] lSum = new int[len];
        int[] rSum = new int[len];
        tmpL[0] = arr[0];
        lSum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            if (tmpL[i - 1] > 0) {
                tmpL[i] = tmpL[i - 1] + arr[i];
            } else {
                tmpL[i] = arr[i];
            }
            lSum[i] = Math.max(tmpL[i], lSum[i - 1]);

        }
        tmpR[len - 1] = arr[len - 1];
        rSum[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (tmpR[i + 1] > 0) {
                tmpR[i] = tmpR[i + 1] + arr[i];
            } else {
                tmpR[i] = arr[i];
            }
            rSum[i] = Math.max(tmpR[i], rSum[i + 1]);
        }
        //注意res一定要设为最小值，因为序列可能全为负数
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, lSum[i] + rSum[i + 1]);
        }
        return res;
    }

}
