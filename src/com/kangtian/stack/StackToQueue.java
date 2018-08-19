package com.kangtian.stack;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();//用来进行push操作
    Stack<Integer> stack2 = new Stack<Integer>();//用来进行pop操作
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if (stack2.isEmpty()){//当stack2为空时，尝试将stack1的所有元素移到stack2.
            //将stack1的所有元素移到stack2.由于经过stack1和Stack2后，后进先出的,变为先进先出的队列
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
          return  stack2.pop();
    }

}
