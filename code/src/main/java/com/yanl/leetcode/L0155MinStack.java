package com.yanl.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YanL
 * @date 22:16 2020/9/5
 * 设计一个最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 借助辅助栈，一个保存最小值的栈
 * 如果插入元素小于辅助站栈顶的话压入辅助栈
 * 弹出元素时，如果数据栈元素与辅助栈相等，辅助栈也需要弹出
 *
 *
 */
public class L0155MinStack {

    /**
     * 数据栈
     * 和最小值栈
     */
    private Deque<Integer> dataStack;
    private Deque<Integer> minStack;

    public L0155MinStack(){
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    public void push(int x) {
        dataStack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = dataStack.pop();
        if(!minStack.isEmpty() && x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        if(!dataStack.isEmpty()) {
            return dataStack.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
