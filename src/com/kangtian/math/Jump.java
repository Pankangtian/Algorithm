package com.kangtian.math;

public class Jump {
    /**
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 用递推可知其结果为斐波那契数列f(n)=f(n-1)+f(n-2)
     */
    public int JumpFloor(int target) {
        int last=1,latter=2,result=0;
        if (1==target)
            return 1;
        else if (2==target)
            return 2;
        else {
            for (int i=3;i<=target;i++){
                result=last+latter;
                last=latter;
                latter=result;
            }
            return result;
        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 罗列各项，寻找规律，可知f(n)=2的n-1次方
     * @param number
     * @return
     */
    static int jumpFloorII(int number) {
        int result=1;
        return result<<(number-1);//将乘法优化为位运算
    }
    public static void main(String[] q){

    }
}
