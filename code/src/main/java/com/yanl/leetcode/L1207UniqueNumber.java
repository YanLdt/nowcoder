package com.yanl.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YanL
 * @date 20:10 2020/10/28
 * 独一无二的出现次数
 * 给一个整数数组arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * 首先排序 然后使用set保存每个数字出现的次数，如果存在重复的次数直接返回false
 */
public class L1207UniqueNumber {
    public boolean uniqueOccurrence(int[] arr){
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int count = 1;
            while (i < len - 1){
                if(arr[i+1] == arr[i]){
                    count ++;
                    i ++;
                }else {
                    break;
                }
            }
            if(set.contains(count)){
                return false;
            }else {
                set.add(count);
            }
        }
        return true;
    }
}
