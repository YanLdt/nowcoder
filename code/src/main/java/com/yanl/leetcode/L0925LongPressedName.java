package com.yanl.leetcode;

/**
 * @author YanL
 * @date 14:57 2020/10/21
 * 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，
 * 按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字
 * （其中一些字符可能被长按），那么就返回 True。
 * 能够匹配成功的两种情况
 * 1.n[i] == t[j]
 * 2.n[i] != t[j] 此时需要 t[j] == t[j-1]
 */
public class L0925LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int lenN = name.length();
        int lenT = typed.length();
        if(lenT < lenN){
            return false;
        }
        int ni = 0;
        int ti = 0;
        while (ti < lenT){
            if(ni < lenN && name.charAt(ni) == typed.charAt(ti)){
                ni ++;
                ti ++;
            }else if(ti > 0 && typed.charAt(ti) == typed.charAt(ti - 1)){
                ti ++;
            }else{
                return false;
            }
        }
        return ni == lenN;
    }
}
