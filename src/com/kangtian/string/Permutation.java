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
