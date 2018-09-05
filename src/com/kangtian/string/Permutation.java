package com.kangtian.string;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static ArrayList<String> Permutation(String str) {
        if(str==null || str==""){
            return null;
        }
        int len =str.length();
        Set<Character>  set=new HashSet<Character>(len);
        for (int i=0;i<len;i++){
            set.add(str.charAt(i));
        }
        ArrayList<Character> arrayList=new ArrayList<>(set);
        p(arrayList,"");

        return null;
    }
    public static  void  p(ArrayList<Character> arrayList,  String re){
        for (int i=0;i<arrayList.size();i++){
            re+=arrayList.get(i);
            arrayList.remove(i);
            System.out.println(re);
            p(arrayList,re);
        }

    }



    public static Set removeRepeatChar(String s) {
        if (s == null) {
            return null;
        }
        int len =s.length();
        Set<Character>  set=new HashSet<Character>(len);
        int i=0;
        while (i < len) {
           set.add(s.charAt(i++));
        }
        return set;
        }
        public static void main(String[] args){
            Permutation("sfhs");
        }
    }
