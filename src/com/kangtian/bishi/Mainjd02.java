package com.kangtian.bishi;



/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */


import java.util.Scanner;

public class Mainjd02 {
    static int result=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int n=in.nextInt();
       int[][] arr=new int[n][3];
       for (int i=0;i<n;i++)
           for (int j=0;j<3;j++)
               arr[i][j]=in.nextInt();
       for (int i=0;i<n;i++)
        bool(arr,i,n);
       System.out.println(result);

    }
    public static void bool(int[] [] arr,int index,int len){
        if (index<len) {
            for (int i = 0; i < len; i++) {
                if (arr[i][0] > arr[index][0] & arr[i][1] > arr[index][1] & arr[i][2] > arr[index][2]) {
                    result++;
                    break;
                }
            }
        }
    }


}