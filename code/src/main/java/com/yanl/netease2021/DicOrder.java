package com.yanl.netease2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 给定长度为 m 的序列 T ,求一个长度为 n 且字典序最小的排列.并且要求序列 T 为所求排列的子序列.题目保证这样的排列一定存在.
 * S 是 T 的子序列,当且仅当 S 是 T 通过删除任意数量元素所得到的.
 * 字典序是单词在字典中的排列顺序，先比较第一个字母，然后比较第二个字母，依次类推。
 * 5 3
 * 2 1 5
 * 2 1 3 4 5
 *
 * 5 2
 * 4 2
 * 1 3 4 2 5
 *
 */
public class DicOrder {

    public static int[] dicOrder(int n, int m, int[] arr){
        int[] res = new int[n];
        ArrayList son = (ArrayList) Arrays.asList(arr);
        int slow, fast;
        for(slow = 0; slow < m; slow++){
            for(fast = slow + 1; fast < m; fast++){
                if(arr[fast] > arr[slow]){

                }
            }
        }
        return null;
    }
}
