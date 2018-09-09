package com.kangtian.string;




import java.util.ArrayList;
import java.util.HashSet;


public class Permutation {
  static HashSet<String> set=new HashSet();
    public static ArrayList<String> Permutation(String str) {
        if (str==""||str==null)
            return null;
        char[] arr = str.toCharArray();
        for(int i =0;i<arr.length-1;i++) { //字典排序
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    char temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        permutation(arr,0,arr.length);
        return new ArrayList<>(set);
    }
    public static void permutation(char[] arr, int s, int e) {
        char c;
        if (s < e - 1) {
            permutation(arr, s + 1, e);//排序剩下的e-s-1
            for (int i = s + 1; i < e; i++) {
                c = arr[s]; //将剩下e-s-1个交换到s处
                arr[s] = arr[i];
                arr[i] = c;
                permutation(arr, s + 1, e);//排序剩下的e-s-1个
                arr[i]=arr[s]; //还原数组
                arr[s] = c;
            }
        } else {
           if (arr.length>0)
           set.add(new String(arr));
        }
    }
    public static void main(String[] args){
        ArrayList<String> arr = Permutation("aa");
        int len=arr.size();
            System.out.println(len);
            for (int i=0;i<len;i++)
                System.out.println(arr.get(i));

    }
    }
