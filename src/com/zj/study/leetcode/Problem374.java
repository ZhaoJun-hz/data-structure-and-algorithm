package com.zj.study.leetcode;

public class Problem374 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(1));
    }

    private static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 1, r = n;
            while(l < r) {
                int mid = l + ((r - l) >> 1);
                int result = guess(mid);
                if(result == 0) {
                    return mid;
                }else if (result == -1) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

    private static class GuessGame {
        public int guess(int n) {
            if(n == 1) return 0;
            else if (n < 1) return -1;
            else return 1;
        }
    }
}
