package com.kangtian.stack;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> dataList=new ArrayList<Integer>();
    ArrayList<Integer> minList=new ArrayList<Integer>();
    private int min=Integer.MAX_VALUE;

    /**采用两个链表，一个链表存储数据，另一个链表存储用于存储最小值
     * 比如dataList为5 4 7 3 2  ，则minList为5 4 4  3 2 。
     * 当执行pop操作时，再同步删除两个链表的值，维护数据
     * 5 4 7 3               5  4 4  3
     * @param node
     */
    public void push(int node) {
        dataList.add(node);
        if (min>node){
            minList.add(node);
            min=node;
        }else {
            minList.add(min);
        }
    }
    public void pop() {
        int size=dataList.size();
        dataList.remove(size-1);
        minList.remove(size-1);
    }

    public int top() {
        return dataList.get(dataList.size()-1);
    }

    public int min() {
    return minList.get(minList.size()-1);
    }
}
