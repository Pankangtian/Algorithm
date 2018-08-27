package com.kangtian.list;

public class RebuildListNode {
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

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1    1  3 4 5 8 9
     * @param list2    2 5 7  8
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head=list1;//记录头部节点
        ListNode tem;
        ListNode node;
        while (list2!=null){// 以list1为链表，将list2插入list1，故判断list2是否为空
            if (list1.next==null){//当list1已到达尾节点时，避免空指针
                if (list1.val<=list2.val) {//list1值小于list2值，则list2后续节点皆大于list2。故可直接将所有节点插入，跳出循环
                    list1.next = list2;
                    break;
                }
                else {//否则将list2的值插入list1前
                    node=new ListNode(list1.val);
                    list1.next=node;
                    list1.val=list2.val;
                    list1=list1.next;
                    list2=list2.next;
                }
            }
            if (list1.val<=list2.val){
                if (list1.next.val>list2.val) {//判断是否合适插入点
                    tem = list1.next;
                    node = new ListNode(list2.val);
                    list1.next = node;
                    node.next = tem;
                    list1=list1.next;
                    list2 = list2.next;
                }
                else//否则继续寻找合适插入点
                    list1=list1.next;
            }else {//互换值，确保list1<list2  （尚可以优化，按 list1.next.val<list2.val）
                int num=list1.val;
                list1.val=list2.val;
                list2.val=num;
            }

        }
        return head;
    }
    public static void main(String[] A){
        ListNode listNode1=new ListNode(3);
        listNode1.next=new ListNode(6);
        listNode1.next.next=new ListNode(8);
        ListNode listNode2=new ListNode(2);
        listNode2.next=new ListNode(4);
        listNode2.next.next=new ListNode(7);
      Merge(listNode1,listNode2);
    }

}
