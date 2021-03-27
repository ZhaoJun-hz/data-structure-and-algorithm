package com.zj.study.leetcode;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/is-subsequence/</a>
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 思路:双指针
 *
 * @author zj
 * @desiription:
 * @date 2021/3/26 10:39 上午
 */
public class Problem392_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // String s = "abc", t = "ahbgdc";
        // System.out.println(solution.isSubsequence(s, t));
        String s = "axc", t = "ahbgdc";
        System.out.println(solution.isSubsequence(s, t));

    }

    private static class Solution {
        public boolean isSubsequence(String s, String t) {
            int n = s.length(), m = t.length();
            int i = 0, j = 0;
            while(i < n && j < m) {
                if(s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == n;
        }
    }
}
