package com.kangtian.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {
    static  String  re="";
  static   int i=0;
    static  TreeNode tem;
  static Stack stack=new Stack();


    //如果root2为root1的子树，则root2的前序遍历字段必为root1的子串
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null)//如果为空，则不必判断
            return false;
            String str1=preTraver(root1);//root1的前序遍历字段
            re="";//置空前序遍历方法的结果串
            String str2=preTraver(root2);//root2的前序遍历字段
            if (str1.contains(str2)) //str1包含str2，则root2为root1的子树
                return true;
            else
                return false;
    }

    /**操作给定的二叉树，将其变换为源二叉树的镜像。
     * 可以用递归的方法将所有的节点的左右节点换位即可
     * @param root
     */
    public static void Mirror(TreeNode root) {
         if (root==null)
             return;
            tem=root.left;//缓存左子树
            root.left=root.right;//将右子树赋值给左子树
            root.right=tem;//将左子树赋值给右子树
            if (root.left!=null)
                Mirror(root.left);//递归左子树
            if (root.right!=null)
                Mirror(root.right);//递归右子树
    }


    //获取树的前序遍历
    public static String preTraver(TreeNode root){
        if (root!=null) {
            re += root.val;
            if (root.left != null)
                preTraver(root.left);
            if (root.right != null)
                preTraver(root.right);
        }
        return re;
    }
    //获取树的后序遍历
    public static String aftTraver(TreeNode root){
        if (root!=null) {
            if (root.left != null)
                preTraver(root.left);
            if (root.right != null)
                preTraver(root.right);
            re += root.val;
        }
        return re;
    }
    //获取树的层次遍历
    public static String levelTraver(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode node;
     if (root!=null)
         queue.offer(root);
     while (!queue.isEmpty()){
         node=queue.poll();
         re+=node.val;
         if (node.left!=null)
             queue.offer(node.left);
         if (node.right!=null)
             queue.offer(node.right);
     }
        return re;
    }
    public static TreeNode reassignTree(TreeNode root){
        if (root!=null) {
            if (root.left != null)
                reassignTree(root.left);
             root.val= (int) stack.pop();
            if (root.right != null)
                reassignTree(root.right);
        }
        return root;
    }

    //获取树的中序遍历
    public static String medTraver(TreeNode root){
        if (root!=null) {
            if (root.left != null)
                medTraver(root.left);
            re += root.val;
            if (root.right != null)
                medTraver(root.right);
        }
        return re;
    }
    //获取树的中序遍历
    public static String medTraver1(TreeNode root){
        if (root!=null) {
            if (root.left != null)
                medTraver1(root.left);
            stack.push(root.val);
            if (root.right != null)
                medTraver1(root.right);
        }
        return re;
    }
    public static void main(String[] A){
        TreeNode root=new TreeNode(22);
        root.left=new TreeNode(3);
        root.right=new TreeNode(4);
        Mirror(root);
    }

}
