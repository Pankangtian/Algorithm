package com.kangtian.list;

import java.util.HashMap;

public class CloneList {

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<Integer,RandomListNode>  data= new HashMap<>();
        if (pHead==null)
            return null;
        RandomListNode tempPHead=pHead;
        RandomListNode head, tempHead, foot;
        foot=new RandomListNode(pHead.label);
        data.put(pHead.label,foot);
        head=foot;
        //拷贝简单的链表
        while (pHead!=null){
            pHead=pHead.next;
            foot.next=new RandomListNode(pHead.label);
            foot=foot.next;
            data.put(pHead.label,foot);
        }
        tempHead=head;
        //拷贝random
        while (tempPHead!=null){
            if (tempPHead.random!=null){
                tempHead.random= data.get(tempPHead.random.label);
            }
            tempHead=tempHead.next;
            tempPHead=tempPHead.next;
        }
        return head;
    }
}
