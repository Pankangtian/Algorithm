package com.kangtian.math;



/**
 *斐波那契数列
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、
 * 因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，
 * 故又称为“兔子数列”，指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 */
public class FibonacciSequence {
    public static int Fibonacci(int n) {
        int last=1,latter=1,result=0;
        if (0==n)
            return 0;
        else if (1==n||2==n)
            return 1;
        else {
            for (int i=3;i<=n;i++){
                result=last+latter;
                last=latter;
                latter=result;
            }
            return result;
        }
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *罗列各项，寻找规律，递推可知其结果为斐波那契数列f(n)=f(n-1)+f(n-2)
     * @param target
     * @return
     */
    int rectCover(int target) {
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
    public static void main(String[] args){
       System.out.print(Fibonacci(4));
    }
}
