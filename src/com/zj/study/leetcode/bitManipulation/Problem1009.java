package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/complement-of-base-10-integer/</a>
 * <p>
 * 每个非负整数 N 都有其二进制表示。例如，5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。
 * 注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 * <p>
 * 思路: 找出最高位1 的位置n, 1 左移 n 然后减去1, 与原数异或
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 9:09 下午
 */
public class Problem1009 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.bitwiseComplement(5));
        System.out.println(solution.bitwiseComplement(1));
    }

    private static class Solution {
        public int bitwiseComplement(int N) {
            if (N == 0) return 1;
            int maxOnePosition = 0;
            int temp = N;
            while (temp != 0) {
                maxOnePosition++;
                temp = temp >> 1;
            }
            return N ^ ((1 << maxOnePosition) - 1);
        }
    }
}
