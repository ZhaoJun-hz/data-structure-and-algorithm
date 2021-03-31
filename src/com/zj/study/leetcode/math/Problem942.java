package com.zj.study.leetcode.math;

import java.util.Arrays;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/di-string-match/</a>
 *
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 3:44 下午
 */
public class Problem942 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
        System.out.println(Arrays.toString(solution.diStringMatch("III")));
        System.out.println(Arrays.toString(solution.diStringMatch("DDI")));
        System.out.println(Arrays.toString(solution.diStringMatch("I")));
        System.out.println(Arrays.toString(solution.diStringMatch("D")));
    }

    private static class Solution {
        public int[] diStringMatch(String S) {
            int[] result = new int[S.length() + 1];
            int length = S.length();
            int max = length, min = 0;
            for (int i = 0; i < S.length(); i++) {
                char temp = S.charAt(i);
                if(temp == 'I') {
                    result[i] = min++;
                }else {
                    result[i] = max--;
                }
            }
            result[length] = min;
            return result;
        }
    }
}
