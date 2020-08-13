package com.yanl.bilibili;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YanL
 * @date 14:11 2020/8/13
 * 从标准输入读取字符串，按照指定的两层分隔符切分成多对key-value，依次输出到标准输出中。
 * 注意：仅输出key和value都为非空串的pair。
 *
 * 每一行有效输入为三列，列之间以' '分隔，
 * 第一列表示key_value_pairs_delimiter，
 * 第二列表示key_value_delimiter，
 * 第三列表示待切分的字符串。分隔符' '不会出现在列内容中。
 * 输入样例：
 * # : a:3#b:8#c:9
 *
 * 先输出有效key-value对的个数（单独一行）；再依次输出key-value对，每一对单独成行，以' ‘分隔key和value。
 * 输出样例：
 * 3
 * a 3
 * b 8
 * c 9
 */
public class StringSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        if(st.length() < 5){
            System.out.println(0);
            return;
        }
        String[] strs = st.split(" ");
        String pairDelimiter = strs[0];
        String keyValueDelimiter = strs[1];
        String str = strs[2];
        String[] result = str.split(pairDelimiter);
        int count = 0;
        ArrayList<String[]> res = new ArrayList<>();
        for(String s : result){
            String[] pairs = s.split(keyValueDelimiter);
            if(pairs.length == 2){
                String[] tmp = new String[]{pairs[0], pairs[1]};
                res.add(tmp);
                count++;
            }
        }
        System.out.println(count);
        for(String[] s : res){
            System.out.println(s[0] + " " + s[1]);
        }
    }
}
