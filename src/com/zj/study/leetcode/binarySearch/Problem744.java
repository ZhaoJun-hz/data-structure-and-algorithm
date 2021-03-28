package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/3/26 10:40 上午
 */
public class Problem744 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // char[] letters = {'c', 'f', 'j'};
        // char target = 'a';
        // System.out.println(solution.nextGreatestLetter(letters, target));

        // char[] letters = new char[]{'c', 'f', 'j'};
        // char target = 'c';
        // System.out.println(solution.nextGreatestLetter(letters, target));

        // char[] letters = new char[]{'c', 'f', 'j'};
        // char target = 'd';
        // System.out.println(solution.nextGreatestLetter(letters, target));

        // char[] letters = new char[]{'c', 'f', 'j'};
        // char target = 'g';
        // System.out.println(solution.nextGreatestLetter(letters, target));

        // char[] letters = new char[]{'c', 'f', 'j'};
        // char target = 'j';
        // System.out.println(solution.nextGreatestLetter(letters, target));

        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'k';
        System.out.println(solution.nextGreatestLetter(letters, target));
    }

    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int l = 0, r = letters.length, mid;
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (letters[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return letters[l % letters.length];
        }
    }
}
