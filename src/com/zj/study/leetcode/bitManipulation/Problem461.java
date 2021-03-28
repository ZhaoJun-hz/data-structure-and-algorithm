package com.zj.study.leetcode.bitManipulation;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/hamming-distance/</a>
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 思路: 异或  异或结果1的个数
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 3:58 下午
 */
public class Problem461 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1, y = 4;
        System.out.println(solution.hammingDistance(1, 4));
    }

    private static class Solution {
        public int hammingDistance(int x, int y) {
            int temp = x ^ y;
            int result = 0;
            while (temp != 0) {
                temp &= (temp - 1);
                result ++;
            }
            return result;
        }
    }
}
