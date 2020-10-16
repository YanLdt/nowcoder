package com.yanl.ebay;

import java.util.*;

/**
 * @author YanL
 * @date 19:53 2020/10/16
 *
 */
public class ValidString {

    static Map<Character, Character> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i = 0; i < n; i ++){
            String s = sc.nextLine();
            if(isValid(s)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }
    }

    public static boolean isValid(String s){
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(char c : chars){
            if(map.containsKey(c)){
                if(stack.isEmpty() || !stack.peek().equals(map.get(c))){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
