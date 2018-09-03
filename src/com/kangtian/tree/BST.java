package com.kangtian.tree;

public class BST {

    /**
     * 搜索二叉树的右节点大于左节点大于根，而最右边的为根节点。
     * 可采用分治理念，从左到右查找，第一个大于根节点所在即为第一个右子树节点，其左边都为左子树。
     * 只要右边有小于根节点的存在，即不符合二分搜索树
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        int len=sequence.length;
        if (len==0)
            return false;
        if (len==1)
            return true;
        return VerifySquenceOfBST(sequence,0,len-1);
    }
    public static boolean VerifySquenceOfBST(int [] sequence,int left,int right) {
        if (left>right) //当left>right时，递归已到最后一个节点
            return true;
        int i=left;
        int root=sequence[right];
        while (i<right){ //查找左右子树分界点
            if (sequence[i++]>root){
                break;
            }
        }
        for (int k=i;k<right;k++){ //遍历右边，如果右子树中存在小于根节点的，则不符合二分搜索树
            if (sequence[k]<root)
                return false;
        }
        return VerifySquenceOfBST(sequence,left,i-1)& VerifySquenceOfBST(sequence,i,right-1);
    }

    public static void main(String[] args){
        int[] arr={4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(arr));
    }

}
