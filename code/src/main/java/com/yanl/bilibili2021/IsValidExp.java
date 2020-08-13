package com.yanl.bilibili2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author YanL
 * @date 19:44 2020/8/13
 */
public class IsValidExp {
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp == '{' || tmp == '['){
                stack.push(tmp);
            }else {
                char tmp1 = map.get(tmp);
                if(stack.isEmpty()){
                   return true;
                }
                if(tmp1 != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
