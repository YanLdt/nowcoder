package com.yanl.netease;

/**
 * @author YanL
 * @date 14:16 2020/8/8
 * n根柱子，可以从i跳到j当且仅当hj <= hi且 hj-hi<=k
 * 有一次超能力，可以跳到任意hj-hi<=k，无视柱子高度
 * 输出描述:
 * 对于每组数据，输出YES或NO
 * 输入例子1:
 * 1
 * 5 3
 * 6 2 4 3 8
 * 输出例子1:
 * YES
 * 输入例子2:
 * 1
 * 5 2
 * 1 8 2 3 4
 * 输出例子2:
 * NO
 */
public class Jump {

    public static boolean isDone(int[] arr, int len, int k){
        int i, j;
        boolean power = true;
        for(i = 0; i < len; i++){
            for(j = i+1; j < len && j <= k + i; j++){

            }
        }
        return false;
    }
}
