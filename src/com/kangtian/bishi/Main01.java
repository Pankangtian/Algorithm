package com.kangtian.bishi;

import java.util.Scanner;
public class Main01 {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
         int n = scan.nextInt();
         int[] arr=new  int[n];
         if (n==0){
             System.out.println(0);
         }else {
             int re = 1;
             for (int i = 0; i < n; i++)
                 arr[i] = scan.nextInt();
             int num;
             for (int i = 0; i < n; i++) {
                 num = num = arr[i] >> 8 - 7;
                 if (num == 0) {
                     i++;
                 } else {
                     num = arr[i] >> 8 - 3;
                     if (num != 6) {
                         num = arr[i] >> 8 - 4;
                         if (num != 12) {
                             num = arr[i] >> 8 - 5;
                             if (num != 28) {
                                 re = 0;
                                 break;
                             } else {
                                 if (i + 3 >= n) {
                                     re = 0;
                                     break;
                                 }

                                 if (arr[++i] >> 6 != 2 || arr[++i] >> 6 != 2 || arr[++i] >> 6 != 2) {
                                     re = 0;
                                     break;
                                 }

                             }

                         } else {
                             if (i + 2 >= n) {
                                 re = 0;
                                 break;
                             }
                             if (arr[++i] >> 6 != 2 || arr[++i] >> 6 != 2) {
                                 re = 0;
                                 break;
                             }
                         }
                     } else {
                         if (i + 1 >= n) {
                             re = 0;
                             break;
                         }
                         if (arr[++i] >> 6 != 2) {
                             re = 0;
                             break;
                         }
                     }

                 }

             }
             System.out.println(re);
         }
    }
}
