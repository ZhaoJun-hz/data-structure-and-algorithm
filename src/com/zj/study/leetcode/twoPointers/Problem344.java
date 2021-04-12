package com.zj.study.leetcode.twoPointers;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/9 2:27 下午
 */
public class Problem344 {
    public static void main(String[] args) {
        char[] s;
        Solution solution = new Solution();
        s = new char[]{'h','e','l','l','o'};
        solution.reverseString(s);
        System.out.println(s);
        s = new char[]{'m','y','n','a','m', 'e'};
        solution.reverseString(s);
        System.out.println(s);
    }

    private static class Solution {
        public void reverseString(char[] s) {
            for (int i = 0, j = s.length - 1; i < j ; ) {
                s[i] = (char) ((char) s[i] ^ s[j]);
                s[j] = (char) (s[i] ^ s[j]);
                s[i] = (char) (s[i] ^ s[j]);
                i++;
                j--;
            }
        }
    }
}
