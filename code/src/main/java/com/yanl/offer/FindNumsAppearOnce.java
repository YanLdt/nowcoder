package com.yanl.offer;

/**
 * @author YanL
 * @date 11:16 2020/8/10
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字
 * 利用两个相同的树异或结果为0，所以数组异或结果就是两个不同的数字异或得到的结果
 *
 */
public class FindNumsAppearOnce {

    public void findNumsAppearOnce(int[] array, int[] num1, int[] num2){
        int len = array.length;
        if(len == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitRes = 0;
        for (int i = 0; i < len; i++) {
           bitRes ^= array[i];
        }
        //找到最终结果的最右边是1的位，然后根据这个将数组分为两组，一组该位为1，一组不为1
        // 分别进行异或即可得到结果
        int indexBit = findFistBitIs1(bitRes);
        for(int a : array){
            if(isBit1(a, indexBit)){
                num1[0] ^= a;
            }else {
                num2[0] ^= a;
            }
        }
    }

    /**
     * 返回数字的二进制表示中最右边是1的位
     * @param num
     * @return
     */
    public int findFistBitIs1(int num){
        int indexBit = 0;
        //此处让数字右移，直到最后一位为1，即最右边第一个1的位
        while ((num & 1) == 0 && indexBit < 32){

            num >>= 1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 判断当前数字的indexBit位是否为1
     * @param num
     * @param indexBit
     * @return
     */
    public boolean isBit1(int num, int indexBit){
        num >>= indexBit;
        return (num & 1) == 1;
    }
}
