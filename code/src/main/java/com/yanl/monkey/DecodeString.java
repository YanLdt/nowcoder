package com.yanl.monkey;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author yanl
 *
 * 猿辅导APP需要下发一些宣传文本给学生，工程师们使用了一种字符压缩算法，为简单起见，
 * 假设被压缩的字符全部为大写字母序列，A,B,C,D....Z,压缩规则如下：
 * 1.AAAB可以压缩为A3B (单字符压缩不加括号)
 * 2.ABABA可以压缩为(AB)2A （多字符串压缩才加括号）
 *
 * 输入数据保证不会出现冗余括号，且表示重复的数字一定合法且大于1，即不会出现：
 * 1.（A)2B   ------- （应为：A2B）
 * 2.  ((AB))2C,-----(应为：（AB)2C  )
 * 3. （A)B  ----- （应为：AB）
 * 4.   A1B，（AB)1C，（应为 AB，ABC）
 *
 * 注意：数字可能出现多位数即A11B或者(AB)10C或者A02这种情况。
 * A11B = AAAAAAAAAAAB
 * (AB)10C = ABABABABABABABABABABC
 * A02 = AA
 *
 * 数据分布：
 * 对于60%的数据，括号不会出现嵌套，即不会有 ((AB)2C)2这种结构。
 * 对于80%的数据，括号最多只嵌套一层，即不会有 (((AB)2C)2D)99 这种结构。
 * 对于100%的数据，括号可以嵌套任意层。
 *
 * 输入描述:
 * 第一行是正整数C(C <= 100)，表示下面有C组数据。之后C行，每行为一组数据，每组数据为一个字符串。
 *
 * 每个字符串由A-Z,数字0-9和(,)组成表示一个压缩后的串，保证输入数据一定合法且字符串长度小于50。
 *
 * 输出描述:
 * 输出C行，每行对应一个数据的输出结果，表示压缩前的字符串，保证每个字符串展开后的长度不超过10^6。
 *
 * 输入例子1:
 * 5
 * A11B
 * (AA)2A
 * ((A2B)2)2G
 * (YUANFUDAO)2JIAYOU
 * A2BC4D2
 *
 * 输出例子1:
 * AAAAAAAAAAAB
 * AAAAA
 * AABAABAABAABG
 * YUANFUDAOYUANFUDAOJIAYOU
 * AABCCCCDD
 */
public class DecodeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineNum = sc.nextInt();
        String[] strs = new String[lineNum];
        while (sc.hasNext()){
            for (int i = 0; i < lineNum; i++) {
                strs[i] = sc.next();
                System.out.println(decode(strs[i]));
            }
        }

    }

    /**
     * 解压缩逻辑
     * 使用栈来保存字符串开始重复的索引
     * @param str 待解压字符串
     * @return 返回解压字符串
     */
    private static String decode(String str){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int len = str.length();
        char c;
        int i = 0, j = 0;
        while(i < len){
            c = str.charAt(i);
            if(c == '('){
                stack.push(sb.length());
                i++;
            }else if(c >= 'A' && c <= 'Z'){
                sb.append(c);
                i++;
            }else if(c >= '0' && c <= '9'){
                j = i;
                while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    i++;
                }
                //这边是取数字前最后一个字符来重复，因为目前还没有遇到右括号，所以重复的就只有数字前面的一个字符
                sb.append(repeat(sb.substring(sb.length() - 1), Integer.parseInt(str.substring(j, i)) - 1));
            }else if(c == ')'){
                i++;
                j = i;
                while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    i++;
                }
                //这边重复的是从左括号开始的一段字符串
                sb.append(repeat(sb.substring(stack.pop()), Integer.parseInt(str.substring(j, i)) - 1));
            }
        }
        return sb.toString();
    }

    /**
     * 重复字符串
     * @param str 字符串2
     * @param n 次数
     * @return 返回解压缩的字符串
     */
    private static String repeat(String str, int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
