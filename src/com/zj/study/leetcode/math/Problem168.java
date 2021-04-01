package com.zj.study.leetcode.math;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/excel-sheet-column-title/</a>
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 6:05 下午
 */
public class Problem168 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // System.out.println(solution.convertToTitle(1));
        // System.out.println(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(51));
        System.out.println(solution.convertToTitle(52));
        System.out.println(solution.convertToTitle(53));
        System.out.println(solution.convertToTitle(701));
    }

    private static class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder builder = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber --;
                builder.insert(0, (char)((columnNumber % 26) + 'A'));
                columnNumber /= 26;
            }
            return builder.toString();
        }
    }
}
