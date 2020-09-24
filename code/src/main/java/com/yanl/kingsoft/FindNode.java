package com.yanl.kingsoft;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:39 2020/9/23
 * 有问题
 */
public class FindNode {

    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] nodes = sc.nextLine().split(" ");
            int[] valS = new int[nodes.length];
            for (int j = 0; j < nodes.length; j++) {
                valS[j] = Integer.parseInt(nodes[j]);
            }
            getLen(valS, 0);
            if(flag){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }

    public static int getLen(int[] nums, int index) {
        int len = nums.length;
        if (index * 2 + 1 >= nums.length / 2) {
            return nums[index*2+1] + nums[index*2+2] + nums[index];
        }
        int left = getLen(nums, index * 2 + 1);
        int right = getLen(nums, index * 2 + 2);
        if(left != right){
            flag = true;
        }
        return nums[index] + left + right;
    }
}
