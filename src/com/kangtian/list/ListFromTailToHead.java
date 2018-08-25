package com.kangtian.list;

import java.util.ArrayList;
import java.util.Stack;

public class ListFromTailToHead {
  static   ArrayList<Integer> arrayList=new ArrayList<Integer>();

    //递归实现
    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null){
            this.printListFromTailToHead(listNode.next);//先递归到末尾元素
            arrayList.add(listNode.val);//依次将元素添加进数组
        }
        return arrayList;
    }

    //利用栈的先进后出
    public  ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while (listNode!=null){ //利用栈的先进后出 将ListNode缓存进栈中
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){//当栈非空时
            arrayList.add(stack.pop());//将元素出栈，并添加到数组里。
        }
        return arrayList;
    }

    //逆转指针
    public static   ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {//假有四个节点，方向1》2,》3,》4  listNode >1
      ListNode buf=listNode; //buf>listNode>      1》2,》3,》4
      ListNode pre=buf;    //pre>buf>listNode>    1》2,》3,》4
      if (listNode==null)
          return  arrayList;
      while (listNode.next!=null){ //判断节点是否还有下一个元素
          buf=listNode.next; //  buf>2>3>4
          listNode.next=buf.next;//   listNode>1>3>4
          buf.next=pre;//buf>2>1>3>4
          pre=buf;//pre>2>1>3>4
      }
      //buf>4>3>2>1
      while (buf!=null){
          arrayList.add(buf.val);
          buf=buf.next;
      }
      return arrayList;
    }






    public  static void main(String[] arg){
       ListNode listNode=new ListNode(0);
       ListNode listNode1=new ListNode(1);
        listNode.next=listNode1;
        ListNode listNode2=new ListNode(2);
        listNode1.next=listNode2;
        ListNode listNode3=new ListNode(3);
        listNode2.next=listNode3;
        printListFromTailToHead2(listNode);
    }
}








