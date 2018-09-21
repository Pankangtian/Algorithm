package com.kangtian.string;

import java.util.ArrayList;
public class Permutation {
    static ArrayList<String> arrayList;
    public static ArrayList<String> Permutation(String str) {
        arrayList = new ArrayList<>();
        if (str == null || str.length() == 0)
            return new ArrayList<>();
        char[] arr = str.toCharArray();
        Permutation(arr, 0);
        sort(arrayList);
        return arrayList;
    }
    public static void Permutation(char[] arr, int i) {
        if (i < arr.length) {
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                Permutation(arr, i + 1);
                swap(arr, i, j);
            }
        } else {
            String tem=String.valueOf(arr);
            if (!arrayList.contains(tem))
            arrayList.add(tem);
        }
    }
    public static void sort(ArrayList<String> list){
        int len=list.size(),j=0;
        if (len>1) {
            String tem;
            for (int i = 0; i < len; i++) {
                tem = list.get(i);
                for (j = i; j > 0 & list.get(j - 1).compareTo(tem) > 0; j--) {//查找i插入的位置j，即j-1处大tem
                    list.set(j, list.get(j - 1));//将j到i-1处的所有元素向后挪一位
                }
                list.set(j, tem);//将原来i处的值赋给j处
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }


    public static String removeRepeatChar(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            sb.append(c);
            i++;
            while (i < len && s.charAt(i) == c) {//这个是如果这两个值相等，就让i+1取下一个元素
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> arlist = Permutation("a");
        for (int i = 0; i < arlist.size(); i++)
            System.out.println(arlist.get(i));
    }

}
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
