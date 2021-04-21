package com.zj.study.leetcode.string;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/20 9:07 上午
 */
public class Problem28_Method1 {
    public static void main(String[] args) {
        String haystack;
        String needle;
        Solution solution = new Solution();

        haystack = "hello";
        needle = "ll";
        System.out.println(solution.strStr(haystack, needle));
        haystack = "aaaaa";
        needle = "bba";
        System.out.println(solution.strStr(haystack, needle));
        haystack = "aabba";
        needle = "bba";
        System.out.println(solution.strStr(haystack, needle));

    }

    private static class Solution {
        public int strStr(String haystack, String needle) {
            int hLength = haystack.length();
            int nLength = needle.length();
            if(nLength > hLength) {
                return -1;
            }
            for (int i = 0; i + nLength <= hLength; i++) {
                boolean flag = true;
                for (int j = 0; j < nLength; j++) {
                    if(haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return i;
                }
            }
            return -1;
        }
    }
}
