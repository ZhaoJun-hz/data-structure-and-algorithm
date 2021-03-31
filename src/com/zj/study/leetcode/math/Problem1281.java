package com.zj.study.leetcode.math;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/</a>
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * 思路: 数学
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 12:49 下午
 */
public class Problem1281 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subtractProductAndSum(234));
        System.out.println(solution.subtractProductAndSum(4421));
        System.out.println(solution.subtractProductAndSum(100));
    }

    private static class Solution {
        public int subtractProductAndSum(int n) {
            int mul = 1;
            int sum = 0;
            while (n > 0) {
                int temp = n % 10;
                sum += temp;
                mul *= temp;
                n /= 10;
            }
            return mul - sum;
        }
    }
}