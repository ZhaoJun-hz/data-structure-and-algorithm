package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/number-complement/</a>
 * <p>
 * 给你一个 正整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * 思路: 找出最高位1 的位置n, 1 左移 n 然后减去1, 与原数异或
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 9:09 下午
 */
public class Problem476 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
    }

    private static class Solution {
        public int findComplement(int num) {
            int maxOnePosition = 0;
            int temp = num;
            while (temp != 0) {
                maxOnePosition++;
                temp = temp >> 1;
            }
            return num ^ ((1 << maxOnePosition) - 1);
        }
    }
}
