package com.zj.study.leetcode.bitManipulation;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/reverse-bits/</a>
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 思路: 位运算,手动改变结果二进制的值
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 3:24 下午
 */
public class Problem190 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(43261596));
        System.out.println(solution.reverseBits(-3));
    }

    private static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            int tempIndex = 31;
            while (n != 0) {
                int temp = n & 1;
                 if (temp == 1) {
                     result = result | (1 << tempIndex);
                 }
                 tempIndex --;
                 n = n >>> 1;
            }
            return result;
        }
    }
}
