package com.yanl.vivo0912;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:47 2020/9/12
 */
public class DeleteChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int left = 0;
        int right = len - 1;
        boolean flag = false;
        int index = 0;
        while (left < right){
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if(!flag){
                if(leftC != rightC){
                    flag = true;
                    if(s.charAt(left + 1) == rightC){
                        index = left;
                        left++;
                    }else if(s.charAt(right - 1) == leftC){
                        index = right;
                        right--;
                    }else {
                        System.out.println("false");
                        return;
                    }
                }
            }
            left++;
            right--;
        }
        String res = s.substring(0, index).concat(s.substring(index+1, len));
        System.out.println(res);
    }
}
