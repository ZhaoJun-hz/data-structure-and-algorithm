package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/find-the-difference/</a>
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * @author zj
 * @desiription:
 * @date 2021/3/28 1:57 下午
 */
public class Problem389 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";
        String t = "";

        s = new String("abcd");
        t = new String("abcde");
        System.out.println(solution.findTheDifference(s, t));

        s = new String("");
        t = new String("y");
        System.out.println(solution.findTheDifference(s, t));

        s = new String("a");
        t = new String("aa");
        System.out.println(solution.findTheDifference(s, t));

        s = new String("ae");
        t = new String("aea");
        System.out.println(solution.findTheDifference(s, t));
    }


    private static class Solution {
        public char findTheDifference(String s, String t) {
            char result = 0;
            for (int i = 0; i < s.length(); i++) {
                result ^= s.charAt(i);
            }
            for (int i = 0; i < t.length(); i++) {
                result ^= t.charAt(i);
            }
            return result;
        }
    }
}
