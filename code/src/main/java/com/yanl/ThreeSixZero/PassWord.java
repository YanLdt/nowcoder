package com.yanl.ThreeSixZero;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:53 2020/9/11
 */
public class PassWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() >= 8 && checkType(s)) {
                System.out.println("Ok");
            } else {
                System.out.println("Irregular password");
            }
        }
    }

    public static boolean checkType(String s) {
        boolean flagNumber = false;
        boolean flagCharacter = false;
        boolean flagBigC = false;
        boolean flagSmallC = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                flagNumber = true;
            } else if (Character.isLowerCase(c)) {
                flagSmallC = true;
            } else if (Character.isUpperCase(c)) {
                flagBigC = true;
            } else {
                flagCharacter = true;
            }
        }
        return flagBigC && flagCharacter && flagNumber && flagSmallC;
    }
}
