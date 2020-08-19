package com.yanl.meituan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author YanL
 * @date 14:18 2020/8/19
 * 小团是一个旅游爱好者，快要过春节了，他想统计一下，在过去的一年中他进行过几次旅行，于是他打开了美团app的订单记录，
 * 记录显示了他的购买车票的记录。记录是按时间顺序给出的，已知一次旅行的线路一定是一个闭环，
 * 即起点和终点是同一个地点。因此当每找到一段闭合的行程，即认为完成了一次旅行。
 * 数据保证不会出现不在闭环路径中的数据。请你在小团的购票记录中统计出他全年共进行了多少次旅行？
 *
 * 输入第一行包含一个正整数n，表示小团的购票记录数量。(1<=n<=10000)
 *
 * 接下来有n行，每行是两个长度不超过10的仅由小写字母组成的字符串S_a，S_b，表示购买了一张从S_a到S_b的车票。
 *
 * 输出仅包含一个整数，表示小团的旅行次数。
 * 6
 * beijing nanjing
 * nanjing guangzhou
 * guangzhou shanghai
 * shanghai beijing
 * fuzhou beijing
 * beijing fuzhou
 *
 * 2
 *
 * 考虑使用栈也行，当前元素与栈顶元素相同则弹出，栈为空则+1；
 */
public class Travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
        ArrayList<String[]> travels = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            String[] str = sc.nextLine().split(" ");
            travels.add(str);
        }
        int len = 0;
        for (int i = 0; i < travels.size()-1; i++) {
            if(!travels.get(i)[1].equals(travels.get(i + 1)[0])){
                len++;
            }
        }
        //最后一个肯定是闭环
        len += 1;
        System.out.println(len);
    }
}
