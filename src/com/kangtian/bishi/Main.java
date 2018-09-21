package com.kangtian.bishi;



/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */


/**
 * 你好，图的问题能给个图示吗？
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int n=in.nextInt();
       int len=in.nextInt();
       int line=in.nextInt();
       int[][] arr=new int[n][len];
       for (int i=0;i<n;i++)
           for (int j=0;j<len;j++)
               arr[i][j]=in.nextInt();
       System.out.println(isXX(arr)?"Yes":"No");
    }
    public static boolean  isXX(int[][] arr){

        return true;
    }
}