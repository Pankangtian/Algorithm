package com.kangtian.bishi;



/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input=in.nextLine();
        System.out.println(findMax(input));

    }
    public  static int findMax(String str){
       int maxLen=0;
       String maxStr="";
        ArrayList<Character> list =new ArrayList<Character>();
        int i=0;
       while (i<str.length()){
           if (!list.contains(str.charAt(i)))
               list.add(str.charAt(i++));
           else {
               if (list.size()>maxLen) {
                   maxLen = list.size();
                   maxStr=list.toString();
               }

            int j= list.indexOf(str.charAt(i));
           while (j>=0) {
               list.remove(0);
               j--;
           }
           list.add(str.charAt(i++));
           }
       }
        if (list.size()>maxLen) {
            maxLen = list.size();
            maxStr=list.toString();
        }
       return maxLen;
    }

}