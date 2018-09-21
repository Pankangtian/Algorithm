package com.kangtian.array;

import java.util.ArrayList;

public class KMin {
    int size=0;
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int [] arr=new int[k];
        ArrayList<Integer> arrayList=new ArrayList<Integer>(k );
        if (k>input.length||k==0)
            return arrayList;
        for (int i=0;i<input.length;i++){
            insert(input[i],arr);
        }
        for (int i=0;i<k;i++){
            arrayList.add(arr[i]);
        }
        return arrayList;
    }
    public void insert(int num,int[] arr) {
        if (arr[size] == 0) {
            arr[size] = num;
            if (size<arr.length-1)
                size++;
        } else {
            if (arr[size] > num) {
                arr[size] = num;
                sort(arr);
            }
        }
    }
    public  void sort(int[] arr){
        int len=size+1,tem=0,j=0;
        for (int i=0;i<len;i++){
            tem=arr[i];
            for ( j=i;j>0&&arr[j-1]>tem;j--){//查找i插入的位置j，即j-1处大tem
                arr[j]=arr[j-1];//将j到i-1处的所有元素向后挪一位
            }
            arr[j]=tem;//将原来i处的值赋给j处
        }
    }




        public static void main(String[] a){
        int arr[]={4,5,1,6,2,7,3,8};
        new KMin().GetLeastNumbers_Solution(arr,4);
        }

}
