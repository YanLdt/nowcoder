package com.yanl.monkey;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author YanL
 * @date 18:23 2020/8/1
 * 猿辅导老师在直播课上和同学们做游戏，让同学们在聊天区报自己的学号，每报一次可以获得一个礼物。
 * 但是老师不给报数次数超过了一定的次数的同学发礼物。
 * 现在请你来帮助老师把聊天区的报数数列处理一下。
 * 规定，当发现某个数大于 m 次时，则认定为报数过多，我们需要得到去除这些学生的报数后的报数数列。
 *
 * 输入描述:
 * 第一行：两个数，学生报数总个数n，和允许的最大重复次数 m，以空格分隔
 * 第二行：n个整数，表示学生所有报数数列，以空格分隔，范围是-2147483648~2147483647
 *
 * 输出描述:
 * 只有一行，去除超出m次的报数数字后的报数数列，该数列不改变原报数顺序，数列以空格分隔
 *
 * 输入例子1:
 * 7 2
 * 4 3 3 3 1 5 5
 *
 * 输出例子1:
 * 4 1 5 5
 */
public class DeleteNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, max;
        int[] arr;
        number = sc.nextInt();
        max = sc.nextInt();
        arr = new int[number];
        for(int i = 0; i < number; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(delete(arr, number, max));
    }
    private static String delete(int[] arr, int number, int max){
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            //当hashMap里没有num这个key的时候返回0，存在则返回对应的值
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i < number; i++){
            if(map.get(arr[i]) > max){
                continue;
            }
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
