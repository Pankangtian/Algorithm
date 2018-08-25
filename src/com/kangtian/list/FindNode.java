package com.kangtian.list;


public class FindNode {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode tem=head;//缓根节点
        while (k>0&tem!=null) { //tem 先行到k处
            tem = tem.next;
            k--;
        }
        if(k!=0)
            return null;
        while (tem!=null){//head和tem一起向下走，当tem是尾节点。head所在位置恰好与tem相差k
            head=head.next;
            tem=tem.next;
        }
        return head;
    }
}
