package com.yanl.offer;

/**
 * @author YanL
 * @date 17:29 2020/8/10
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    public int sum(int n) {
        int res = n;
        //逻辑短路，当n==0时不会执行后面的判断
        boolean flag = (n > 0) && ((res+=sum(n-1)) > 0);
        return res;
    }
}
