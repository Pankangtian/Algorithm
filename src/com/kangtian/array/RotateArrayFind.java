package com.kangtian.array;

public class RotateArrayFind {
    public int minNumberInRotateArray(int [] array) {
        int start=0;
        int end=array.length-1;
        int mid;
        if (end<0)//长度为零直接返回0
            return 0;
        if (end==0)//长度为1直接返回array[0]处数值
            return array[0];
        while (start<end){//循环数组
            //当array[start]>array[start+1] 由有序旋转数组定义可知，array[start+1]即为最小值。array[start]为最大值
            if (array[start]>array[start+1])
                return array[start+1];
            start++;
        }
        return 0;
    }
}
