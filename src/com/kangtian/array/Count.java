package com.kangtian.array;

import java.util.HashMap;

public class Count {
    public static void main(String[] args){
        int [] arr={1,2,3,2,2,2,5,4,2};
        new Count().FindGreatestSumOfSubArray(arr);
       // System.out.println();
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        int max=array[0],tem;
        for (int i=0;i<array.length;i++){
            tem=FindGreatestSumOfSubArray(array,i,max);
            if (max<tem)
                max=tem;
        }

        return max;
    }
    public int FindGreatestSumOfSubArray(int[] array,int begin,int max) {
        int count=0;
        for (int i=begin;i<array.length;i++){
            count+=array[i];
            if (count>max)
                max=count;
            if (count<0)
                return max;
        }
        return max;
    }



















    public int MoreThanHalfNum_Solution(int [] array) {
        int num=0,count=0,tem=1,len=array.length;
        HashMap<Integer,Integer>  temmap=new HashMap<>();
        if(len==1)
            return array[0];
        for (int i=0;i<len/2;i++){
            tem=temmap.get(array[i])==null?0:temmap.get(array[i]);
            if (tem==0)
                temmap.put(array[i],1);
            else
                temmap.put(array[i],++tem);
        }
        for (int i=len/2;i<len&& tem-1<len/2;i++){
            tem=temmap.get(array[i])==null?0:temmap.get(array[i]);
            if (tem==0)
                temmap.put(array[i],1);
            else
                temmap.put(array[i],++tem);
            if (tem>count) {
                count = tem;
                num=array[i];
            }
        }
        if (len/2<count)
            return num;
        else
            return 0;
    }
}
