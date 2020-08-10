package com.yanl.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author YanL
 * @date 15:46 2020/8/10
 * 圆圈中最后剩下的数字
 * 0-n-1排成一圈，从数字0开始没词从圆圈里删除第M个数字，求圆圈中最后剩下的数字
 * 约瑟夫环问题
 * 环形链表
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        if(n < 1 ||m < 1){
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        //初始化链表
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        //使用一个标志来标识是否到达链表尾部，如果到达尾部则将其置位头部
        int cur = -1;
        while (list.size() > 1){
            for(int i = 0; i < m; i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            //经历m之后删除当前值
            list.remove(cur);
            //将指针指向前一个元素
            cur--;
        }
        return list.get(0);
    }
}
