package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/21 4:19 下午
 */
public class Problem639 {
    public static void main(String[] args) {
        String s;
        Solution solution = new Solution();

        s = "*";
        System.out.println(solution.numDecodings(s));
    }

    private static class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int mod = (int) 1e9 + 7;
            if (n == 0 || s.charAt(0) == '0') return 0;
            long[] dp = new long[n + 1];
            char[] a = (" " + s).toCharArray();
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                // 如果a[i] = '*'
                if (a[i] == '*') {
                    // 单独解码
                    // a[i] = 1 到 9 所以 dp[i] = 9 * dp[i - 1]
                    dp[i] = (9 * dp[i - 1]) % mod;
                    // 与i-1位一起解码
                    // 如果a[i-1] = 1 dp[i] = 9 * dp[i - 1] (11, 12, 13, 14, 15, 16, 17, 18, 19)
                    if (a[i - 1] == '1') dp[i] = (dp[i] + 9 * dp[i - 2]) % mod;
                        // 如果a[i - 1] = 2, dp[i] = 6 * dp[i - 1] (21, 22, 23, 24, 25, 26)
                    else if (a[i - 1] == '2') dp[i] = (dp[i] + 6 * dp[i - 2]) % mod;
                        // 如果a[i - 1] = *, 组合方式共有15中, dp[i] = 15 * dp[i - 1] (11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26)
                    else if (a[i - 1] == '*') dp[i] = (dp[i] + 15 * dp[i - 2]) % mod;
                }
                // 如果a[i] = 0, 不能单独解码，且a[i - 1] != 0, a[i - 1] != 3到9
                else if (a[i] == '0') {
                    // 10
                    if (a[i - 1] == '1') dp[i] = dp[i - 2];
                        // 20
                    else if (a[i - 1] == '2') dp[i] = dp[i - 2];
                        // 10, 20
                    else if (a[i - 1] == '*') dp[i] = 2 * dp[i - 2] % mod;
                        // 如果碰到00这种情况， 直接返回0
                    else return 0;
                }
                // 如果a[i] = 1 - 9
                else {
                    // 单独解码
                    dp[i] = dp[i - 1];
                    // 与i-1一起解码
                    // 如果a[i - 1] = 1
                    if (a[i - 1] == '1') dp[i] = (dp[i] + dp[i - 2]) % mod;
                        // 如果a[i - 1] = 2 ,a[i] = 1到6
                    else if (a[i - 1] == '2' && a[i] - '0' >= 1 && a[i] - '0' <= 6) dp[i] = (dp[i] + dp[i - 2]) % mod;
                        // 如果a[i - 1] = *
                    else if (a[i - 1] == '*') {
                        // 如果a[i] = 7,8,9 a[i - 1] 只能为1
                        if (a[i] - '0' >= 7 && a[i] - '0' <= 9) dp[i] = (dp[i] + dp[i - 2]) % mod;
                            // 如果a[i] = 1,2,3,4,5,6,  a[i - 1] 可以为1,2
                        else dp[i] = (dp[i] + 2 * dp[i - 2]) % mod;
                    }
                }

            }
            return (int) (dp[n] % mod);
        }
    }
}
