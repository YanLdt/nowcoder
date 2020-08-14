package com.yanl.ali0812;

/**
 * @author YanL
 * @date 14:35 2020/8/14
 * 小强是一个农场主，农场里有n头牛，
 * 每头牛有着独一无二的体重，每一头牛的颜色可能跟是m种颜色其中的一种，
 * 小强带了一些牛（可能为0个）出来吃草。你需要回答出小强带出来的牛的组合一共有多少种可能？
 *
 * 输入示例：
 * 3 2
 * 输出示例
 * 27
 *
 * 0 1
 * 1 6  C31 * 2^1 = 3 * 2
 * 2 12 C32 * 2^2 = 3*2^2
 * 3 8  C33 * 2^3 = 8
 * 可以带的牛的种类有为  从n头中任选i头牛，不需要顺序
 * 颜色与牛相互没有影响，因为每头牛都不一样
 * (m+1)^n
 */
public class Cow {
    public static void main(String[] args) {
        System.out.println(new Cow().perm(4, 3));
    }
    public int perm(int n, int m){
        int sum = 1;
        int mod = 1000000007;
        for(int i = 1; i <= n; i++){
            int fenM = 1;
            int fenZ = 1;
            for(int j = 0; j < i; j++){
                fenM *= (j+1);
                fenZ *= (n-j);
            }
            int c = fenZ / fenM;
            int color = (int) Math.pow(m, i);
            sum += c * color;
        }
        return sum;
    }
}
