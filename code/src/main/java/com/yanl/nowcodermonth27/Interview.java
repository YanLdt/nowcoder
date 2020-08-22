package com.yanl.nowcodermonth27;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:28 2020/8/22
 * 1:a[x]->y
 * 2:[l,r]区间是否可以形成连续的数字，若对[l,r]进行从小到大排序之后有a[l]=a[l+1]-1=a[l+2]-2=...=a[r]-r+l，
 * l = r时可认为形成一段连续的数字
 * n个数字互不相同
 * 输入
 * 第一行两个整数 n,q
 * 第二行n个正整数a[i]
 * 余下q行 第一个数字为查询类型，
 *  1--> x, y
 *  2--> l, r
 *  若可以形成连续数字输出YES，否则输出NO
 */
public class Interview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++){
            int[] question = new int[3];
            question[0] = sc.nextInt();
            question[1] = sc.nextInt();
            question[2] = sc.nextInt();
            if(question[0] == 1){
                arr[question[1]] = question[2];
            }else {
                if(question[1] == question[2]){
                    System.out.println("YES");
                }else {
                    int[] tmp = new int[question[2] - question[1] + 1];
                    tmp = Arrays.copyOfRange(arr, question[1], question[2]+1);
                    Arrays.sort(tmp);
                    for(int j = question[1], k = 0; j <= question[2]; j++){
                        arr[j] = tmp[k++];
                    }
                    boolean flag = check(tmp);
                    if(flag){
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }

    public static boolean check(int[] arr){
        int len = arr.length;
        int left = 0;
        int right = 1;
        int sum = 0;
        for(int a : arr){
            sum += a;
        }
        int result = (arr[0]+arr[len-1]) * len / 2;
        return result == sum;
    }
}
