package com.yanl.ke;

import java.util.*;

/**
 * @author YanL
 * @date 19:32 2020/8/11
 *
 */
public class OrMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        System.out.println(new OrMin().min(len));
    }
    public int min(int len){
        if(len == 3){
            return 1;
        }else{
            int left = 1;
            int max = len;
            int highBit = 0;
            boolean flag3 = false;
            boolean flag2 = false;
            boolean flag1 = false;
            while(max != 0){
                if(max == 3){
                    flag3 = true;
                    break;
                }
                if(max == 2){
                    flag2 = true;
                    break;
                }
                max >>= 1;
                highBit++;
            }
            if(flag3){
                left = (int)Math.pow(2, highBit) + ((int)Math.pow(2, highBit+2) - 1);
            }
            if(flag2){
                left = (int)Math.pow(2, highBit+1) - 1;
            }
            System.out.println(left);
            return len - left+1;
        }
//        ArrayList<int[]> res = new ArrayList<>();
    }
}
