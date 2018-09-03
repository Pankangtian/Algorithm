package com.kangtian.stack;

import java.util.ArrayList;

public class PopOrder {
   static   ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> outstack = new ArrayList<Integer>();

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        int i = 0;
        int k = 0;
        while (i < len) {
            stack.add(pushA[i]);
            if (pushA[i] == popA[k]) {
                stack.remove((Integer) pushA[i]);
                k++; i++;
            }else
                i++;
            if (stack.size()>0)
            while ((stack.get(stack.size()-1) == popA[k])) {
                k++;
                stack.remove(stack.size() - 1);
                if (stack.size()==0)
                    break;
            }

        }
        if (stack.size()==0)
            return true;
        else
            return false;
    }
    public static  void main(String [] args){
        int[] pushA={1}, popA={1};
       System.out.print(IsPopOrder(pushA,popA));
    }
}
