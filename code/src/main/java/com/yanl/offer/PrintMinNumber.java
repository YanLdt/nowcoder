package com.yanl.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 32, 321};
        System.out.println(minNumber(arr));
    }


    /**
     * 通过排序实现最小字符串，通过判断两个数字前后互相调换拼接成的数字大小进行排序，之后按序输出数组就行
     * @param arr
     * @return
     */
    public static String minNumber(int[] arr){
        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        List<String> strings = new ArrayList<>();
        for (int value : arr) {
            strings.add(String.valueOf(value));
        }
        //实现Comparator接口，自定义进行比较
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1.concat(o2);
                String b = o2.concat(o1);
                return a.compareTo(b);
            }
        });
        for(String s : strings){
            sb.append(s);
        }
        return sb.toString();
    }
}
