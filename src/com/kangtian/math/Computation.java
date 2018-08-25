package com.kangtian.math;

/**
 * 数学运算
 * 等式：-n = ~(n - 1) = ~n + 1（-n等于其各位取反加1）
 * 获取整数n的二进制中最后一个1：-n&n 或(~n+1)&n或 ~(n - 1)&n
 * 去掉整数n的二进制中最后一个1：n&(n - 1)
 */
public class Computation {
    /**
     * 加法实现
     * 例如110  010  6  2
     */
    public static int add(int num1,int num2){
        int carry;
        while (num2!=0){//如有进位，则继续
            carry=(num1&num2)<<1; //获取进位处  100     1000   0
            num1=num1^num2;//获取非进位处的和 100       000    1000
            num2=carry;
        }
        return num1; //1000
    }

    /**
     * 减法实现  减法可转换为加法，又-n = ~(n - 1)
     * @param num1
     * @param num2
     * @return
     */
    public static int less(int num1,int num2){
       return add(num1,add(~num2,1));
    }

    /**乘法实现        10100 a
     *                 1010  b
     *              -------------
     *              101000
     *           10100000
     *    判断b最后一位是否为零，如果为零则b右移一位，a左移一位
     *    如果不为零，则将加上a
     *    循环直至b=0。
     * @param num1
     * @param num2
     * @return
     */
    public static int mul(int num1,int num2){
        int result=0;
        while (num2!=0){
            if ((num2&1)!=0)
                result=add(result,num1);
            num1=num1<<1;
            num2=num2>>1;
        }
        return result;
    }
    //判断是否为偶数
    public static boolean isEven(int num){
        return (num&1)==0;
    }
    //求中间值 (x&y)为x y值相同的， (x^y)为其不同的地方，(x^y)右移1位，即等同于除2
    public static int mean(int x,int y){
       return  (x&y)+((x^y)>>1);
    }

    public static   int abs( int x )
    {
        int y ;
        y = x >> 31 ;//0或1
        return (x^y)-y ;        //or: (x+y)^y
    }


public static void main(String[] arhs){
    Math.pow(2,3);
    System.out.println( add(2,2));
    System.out.println(less(4,2));
    System.out.println(Integer.toBinaryString(20));
    System.out.println(Integer.toBinaryString(~20));
    System.out.println(mul(2,2));
    System.out.println(isEven(3));
    System.out.println(mean(2,4));
}
}
