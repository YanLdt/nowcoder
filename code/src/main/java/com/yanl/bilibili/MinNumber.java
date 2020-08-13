package com.yanl.bilibili;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author YanL
 * @date 23:00 2020/8/12
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
 */
public class MinNumber {
    public String minNumber(int[] arr){
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int a:arr){
            arrayList.add(a);
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1).concat(String.valueOf(o2));
                String s2 = String.valueOf(o2).concat(String.valueOf(o1));
                return s1.compareTo(s2);
            }
        });
        for(int a : arrayList){
            sb.append(a);
        }
        return sb.toString();
    }
}
