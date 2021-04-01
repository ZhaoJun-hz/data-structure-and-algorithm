package com.zj.study.leetcode.math;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/excel-sheet-column-number/</a>
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 10:46 上午
 */
public class Problem171 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String columnTitle = "";

        columnTitle = "A";
        System.out.println(solution.titleToNumber(columnTitle));
        columnTitle = "B";
        System.out.println(solution.titleToNumber(columnTitle));
        columnTitle = "Z";
        System.out.println(solution.titleToNumber(columnTitle));
        columnTitle = "AA";
        System.out.println(solution.titleToNumber(columnTitle));
        columnTitle = "ZY";
        System.out.println(solution.titleToNumber(columnTitle));
    }

    private static class Solution {
        public int titleToNumber(String columnTitle) {
            int result = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
            }
            return result;
        }
    }
}
