package com.yanl.pdd2021;

import java.util.Scanner;

/**
 * @Author: YanL
 * @Time: 20:14 2020/8/2
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 多多鸡决定在自家的农场里种植农作物。农场由6*6总共36块地组成。
 * 农场中有几块地上已经盖了一些建筑。多多鸡手上有棉花、玉米、大豆、油菜、花生、小麦总共6种农作物的种子。
 * 多多鸡打算在没有盖建筑的每一块地上，都种植上一种农作物，并且需要满足每一块地上种植的农作物，
 * 不能与前后左右相邻的4块地相同。
 *
 * 多多鸡想知道，满足他的要求的种植方案总共有多少种。
 *
 * 输入描述:
 * 总共6行，每行有6个字符，#表示这块地上没有建筑，*表示这块地上有建筑。
 * 输出描述:
 * 共一行，最终的方案数对1000000009取余的结果。
 *
 * #*****
 * ******
 * ******
 * ******
 * ******
 * *****#
 * 36
 * ##****
 * ##****
 * ******
 * ******
 * ******
 * ******
 * 630
 *
 * 对于20%的数据，#的个数不超过6。
 */
public class Farm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[6][6];
        for(int i = 0; i < 6; i++){
            char[] tmp = sc.nextLine().toCharArray();
            for(int j = 0; j < 6; j++){
                arr[i][j] = tmp[j];
            }
        }
        System.out.println(plan(arr));
    }

    private static int plan(char[][] arr){
        int count = 1;
        char[][] tmp = new char[8][8];
        for(int row = 0; row < 8; row++){
            tmp[row][0] = '*';
        }
        for(int col = 0; col < 8; col++){
            tmp[col][0] = '*';
        }
        for(int row = 1; row < 7; row++){
            System.arraycopy(arr[row - 1], 0, tmp[row], 1, 6);
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 6; j++){
                if(isAlone(i, j, arr)){
                    count *= 6;
                }else {

                }
            }
        }
        return count;
    }

    private static boolean isAlone(int i, int j, char[][] tmp){

        if(tmp[i+1][j] == '#' || tmp[i-1][j] == '#' || tmp[i][j+1] == '#' || tmp[i][j-1] == '#'){
            return false;
        }
        return true;
    }
}
