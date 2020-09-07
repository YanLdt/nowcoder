package com.yanl.xiaohongshu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YanL
 * @date 19:31 2020/9/6
 * 一个二维数组M,N中存放的是乱序的自然数,求不在数组中出现的最小自然数.
 * int findMin(int[][] arr)
 *
 * 一个二维自然数组,第一行为行数，第二行为列数，后续每行代表二维数组的元素，元素之间以空格隔开
 * 打印出不在该数组中出现的最小的自然数。
 */
public class FindMatrix {

    static int findMin(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        Set<Integer> set = new HashSet<>();
        for (int[] ints : arr) {
            for (int j = 0; j < col; j++) {
                set.add(ints[j]);
            }
        }
        int c = 1;
        while (true){
            if(!set.contains(c)){
                return c;
            }
            c++;
        }
    }
}
