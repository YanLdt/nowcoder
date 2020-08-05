package com.yanl.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YanL
 * @Time: 21:52 2020/8/5
 * @Email: imyanl.dt@gmail.com
 * @Description:
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNumSolution(arr));
    }

    public static int moreThanHalfNumSolution(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        len = len / 2;

        for(int a : array){
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.get(a) > len){
                return a;
            }
        }
        return 0;
    }
}
