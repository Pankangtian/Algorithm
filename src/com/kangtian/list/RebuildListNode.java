package com.kangtian.list;

import com.kangtian.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class RebuildListNode {


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<TreeNode> arrayList=new ArrayList<>();
        if (pRootOfTree==null)
            return null;
        TreeNode node=pRootOfTree;
        //将树的节点以非递归中序遍历的形式添加到list中，此时的list即为有序列表
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                arrayList.add(node);
                node=node.right;
            }
        }
        int len=arrayList.size();
        if (len<=1){
            return arrayList.get(0);
        }
        //改变指针方向，使left指针改为从小到大，right改为从大到小
        for (int i=0;i<len-1;i++){
            arrayList.get(i).right=arrayList.get(i+1);
            arrayList.get(len-1-i).left=arrayList.get(len-i-2);
        }
        return arrayList.get(0);

    }

    /**
     * 逆序链表
     * @param head
     * @return
     */
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
