package com.yanl.mi0908;

import java.util.Scanner;

/**
 * @author YanL
 * @date 18:30 2020/9/8
 * 密码生成器
 * 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，
 * 和特定长度。检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。
 * 符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。
 *
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] passwords = sc.nextLine().split(" ");
        sc.close();
        int len = passwords.length;
        for(String s : passwords){
            if(s.length() < 8 || s.length() > 120){
                System.out.println(1);
            }else if(checkType(s)){
                System.out.println(0);
            }else {
                System.out.println(2);
            }
        }
    }

    public static boolean checkType(String s){
        boolean flagNumber = false;
        boolean flagCharacter = false;
        boolean flagBigC = false;
        boolean flagSmallC = false;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                flagNumber = true;
            }else if(Character.isLowerCase(c)){
                flagSmallC = true;
            }else if(Character.isUpperCase(c)){
                flagBigC = true;
            }else {
                flagCharacter = true;
            }
        }
        return flagBigC && flagCharacter && flagNumber && flagSmallC;
    }
}
