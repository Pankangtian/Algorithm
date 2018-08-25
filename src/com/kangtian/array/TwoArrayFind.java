package com.kangtian.array;

public class TwoArrayFind {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 解题思路。
     * 由于是有序数组，所以左下角的数正好是一个很好的中间数，它的上都小于它，右都大于它，
     * 当target大于它时，令其右移，小于时左移。
     */
    public boolean Find(int target, int [][] array) {
        int colsize=array[0].length;
        int row=array.length-1;
        int col=0;
        while (col<colsize&row>=0){
            if (target>array[row][col]){
                col++;
            }else if (target<array[row][col]){
                row--;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 解题思路。
     * 由于是有序数组，所以可以用二分查找遍历
     */
    public boolean binFind(int target, int [][] array) {
        int cols=array[0].length;
        int rows=array.length;
        int end=cols-1;
        for (int i=0;i<rows;i++){
            int start=0;
            while (start<=end){
                int mid=(start+end)/2;
                if (target<array[i][mid]){
                    end=mid-1;
                }else if (target>array[i][mid]){
                    start=mid+1;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
}
