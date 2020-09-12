package com.yanl.netease20210912;

import java.util.Scanner;

/**
 * @author YanL
 * @date 15:34 2020/9/12
 *
 */
public class CoupleString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int len = s.length();
        int[] dic = new int[6];
        int res = 0;
        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);
            if(dic[0] % 2 == 0 && dic[1] % 2 == 0 && dic[2] % 2 == 0 &&
                    dic[3] % 2 == 0 && dic[4] % 2 == 0 && dic[5] % 2 == 0){
                res = Math.max(res, i);
            }
            if(c == 'a'){
                dic[0]++;
            }else if(c == 'b'){
                dic[1]++;
            }else if(c == 'c'){
                dic[2]++;
            }else if(c == 'x'){
                dic[3]++;
            }else if(c == 'y'){
                dic[4]++;
            }else if(c == 'z'){
                dic[5]++;
            }
        }
        System.out.println(res);

    }
}
