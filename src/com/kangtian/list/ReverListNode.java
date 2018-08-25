package com.kangtian.list;

public class ReverListNode {
    public ListNode ReverseList(ListNode head) {
        ListNode buf = head; //buf>listNode>      1》2,》3,》4
        ListNode pre = buf;    //pre>buf>listNode>    1》2,》3,》4
        if (head == null)
            return null;
        while (head.next != null) { //判断节点是否还有下一个元素
            buf = head.next; //  buf>2>3>4
            head.next = buf.next;//   listNode>1>3>4
            buf.next = pre;//buf>2>1>3>4
            pre = buf;//pre>2>1>3>4
        }
        return buf;
    }
}
