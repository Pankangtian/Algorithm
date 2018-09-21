package com.kangtian.stack;

import java.util.ArrayList;

public class PopOrder {
   static   ArrayList<Integer> stack = new ArrayList<Integer>();
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        int i = 0;
        int k = 0;
        while (i < len) {
            stack.add(pushA[i]);//将序列压入栈中
            if (pushA[i] == popA[k]) {//当栈顶元素等于弹出序列k的值时，说明是栈顶元素出栈了
                stack.remove((Integer) pushA[i]);
                k++; i++;
            }else//否则继续压栈操作
                i++;
            while ((stack.size()>0&&stack.get(stack.size()-1) == popA[k])) {//当栈顶元素等于弹出序列k的值时，说明是栈顶元素该出栈了
                stack.remove(stack.size() - 1);//执行出栈操作
                k++;
            }
        }
        if (stack.size()==0)//所有元素入栈且出栈完，说明其是弹出序列
            return true;
        else
            return false;
    }
    public static  void main(String [] args){
        int[] pushA={1}, popA={1};
       System.out.print(IsPopOrder(pushA,popA));
    }
}
