package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/number-of-1-bits/</a>
 * <p>
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
 * <p>
 * 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * 思路: n & (n - 1) 把最右边的1 去掉
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 3:44 下午
 */
public class Problem191 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight(128));
        System.out.println(solution.hammingWeight(-3));
    }


    private static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int result = 0;
            while (n != 0) {
                n = n & (n - 1);
                result++;
            }
            return result;
        }
    }
}
