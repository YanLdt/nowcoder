package com.yanl.offer;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {

    public static int getCount(int index){
        if(index < 1){
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
        int nextIndex = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (nextIndex < index){
            //更新下一个丑数，下一个丑数应该是下面三者中的最小值
            res[nextIndex] = min(res[i2] * 2, res[i3] * 3, res[i5] * 5);
            while (res[i2] * 2 <= res[nextIndex]){
                i2++;
            }
            while (res[i3] * 3 <= res[nextIndex]){
                i3++;
            }
            while (res[i5] * 5 <= res[nextIndex]){
                i5++;
            }
            nextIndex++;
        }
        return res[index - 1];
    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
