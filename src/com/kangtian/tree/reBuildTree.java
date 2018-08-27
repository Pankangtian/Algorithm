package com.kangtian.tree;


import java.util.HashMap;
public class reBuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len=in.length;
        // 用map是因为其查找效率均衡，在数据量较大时较优.hashMap默认因子为0.75
        HashMap<Integer,Integer> map= new HashMap<Integer, Integer>(len*4/3+2);
        for(int i=0;i<len;i++){
            map.put(in[i],i);
        }
        return reBulid(pre,0,len-1,in,0,len-1,map);
    }
    //递归创建各子树
    public TreeNode reBulid(int [] pre, int prestart, int preend, int [] in, int instart, int inend, HashMap<Integer,Integer> map){
        if(prestart > preend || instart> inend)//说明已无左节点或有节点
            return null;
        TreeNode root = new TreeNode(pre[prestart]);//新建子树的根节点
        //对中序数组进行输入边界的遍历
       //查找子树根节点位置,用map是因为其查找效率均衡，在数据量较大时较优
        int i=map.get(pre[prestart]);
        //递归构建左子树
        //中序遍历的根节点的左边为左子树，并求出器索引位置，前序遍历的前索引位即是左子树，明确边界
        root.left = reBulid(pre,prestart+1,prestart+i-instart,in,instart,i-1,map);
        //递归构建右子树
        //中序遍历的根节点的右边为右子树，并求出其索引位置，前序遍历的后end-索引个即是右子树，明确边界
        root.right = reBulid(pre,prestart+i+1-instart,preend,in,i+1,inend,map);
        return root;
    }
}

