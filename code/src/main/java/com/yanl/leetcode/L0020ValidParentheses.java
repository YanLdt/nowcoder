package com.yanl.leetcode;

import java.util.*;

/**
 * @author YanL
 * @date 0:27 2020/8/25
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */
public class L0020ValidParentheses {
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(char c : chars){
            //如果当前为),],},且栈为空或者栈顶不是配对括号  则构不成有效字符串，直接返回false
            if(map.containsKey(c)){
                if(stack.isEmpty() || !stack.peek().equals(map.get(c))){
                    return false;
                }
                //如果是栈顶为(，[，{则弹出栈中
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
