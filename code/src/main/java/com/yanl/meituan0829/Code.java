package com.yanl.meituan0829;

import java.util.Scanner;

/**
 * @author YanL
 * @date 16:01 2020/8/29
 * 小团深谙保密工作的重要性，因此在某些明文的传输中会使用一种加密策略，
 * 小团如果需要传输一个字符串S，则他会为这个字符串添加一个头部字符串和一个尾部字符串。
 * 头部字符串满足至少包含一个“MT”子序列，且以T结尾。尾部字符串需要满足至少包含一个“MT”子序列，
 * 且以M开头。例如AAAMT和MAAAT都是一个合法的头部字符串，而MTAAA就不是合法的头部字符串。
 * 很显然这样的头尾字符串并不一定是唯一的，因此我们还有一个约束，
 * 就是S是满足头尾字符串合法的情况下的最长的字符串。
 * 很显然这样的加密策略是支持解码的，给出你一个加密后的字符串，请你找出中间被加密的字符串S。
 * 输入第一行是一个正整数n，表示加密后的字符串总长度。(1<=n<=100000)
 * 输入第二行是一个长度为n的仅由大写字母组成的字符串T。
 * 输出仅包含一个字符串S。
10
MMATSATMMT
 * SATM
 */
public class Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int len = str.length();
        int left = 0;
        int right = len - 1;
        int resL = 0;
        int resR = 0;
        //左边是否已经出现MT
        boolean flag1 = true;
        //右边是否已经出现MT
        boolean flag2 = true;
        //T前面是否出现过M
        boolean flagM = false;
        //M后面是否出现T
        boolean flagT = false;
        while (flag1 || flag2){
            if(flag1){
                if(str.charAt(left) == 'M'){
                    flagM = true;
                }
                if(str.charAt(left) == 'T' && flagM){
                        resL = left+1;
                        flag1 = false;
                }
                left++;
            }
            if(flag2){
                if(str.charAt(right) == 'T'){
                    flagT = true;
                }
                if(str.charAt(right) == 'M' && flagT){
                    resR = right;
                    flag2 = false;
                }
                right--;
            }
        }
        String res = str.substring(resL, resR);
        System.out.println(res);
    }
}
