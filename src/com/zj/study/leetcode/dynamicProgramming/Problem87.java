package com.zj.study.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/16 11:31 上午
 */
public class Problem87 {

    public static void main(String[] args) {
        String s1, s2;
        Solution solution = new Solution();
        s1 = "great";
        s2 = "rgeat";
        System.out.println(solution.isScramble(s1, s2));

        s1 = "abcde";
        s2 = "caebd";
        System.out.println(solution.isScramble(s1, s2));
    }

    private static class Solution {
        // 记忆化搜索存储状态的数组
        // -1 表示false 1 表示true 0 表示未计算
        int[][][] memo;
        String s1, s2;


        public boolean isScramble(String s1, String s2) {
            int length = s1.length();
            this.memo = new int[length][length][length + 1];
            this.s1 = s1;
            this.s2 = s2;
            return dfs(0, 0, length);
        }

        // 第一个字符串从 i1 开始， 第二个字符串从i2开始， 子串的长度为length，是否和谐
        private boolean dfs(int i1, int i2, int length) {
            if (memo[i1][i2][length] != 0) {
                return memo[i1][i2][length] == 1;
            }
            // 判断两个子串是否相等
            if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
                memo[i1][i2][length] = 1;
                return true;
            }
            // 判断是否存在字符 c 在两个子串中出现的次数不同
            if( !checkIfSimilar(i1, i2, length)) {
                memo[i1][i2][length] = -1;
                return false;
            }

            // 枚举分割位置
            for (int i = 1; i < length; i++) {
                // 不交换的情况
                if(dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)){
                    memo[i1][i2][length] = 1;
                    return true;
                }
                // 交换的情况
                if(dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }
            }
            memo[i1][i2][length] = -1;
            return false;
        }

        private boolean checkIfSimilar(int i1, int i2, int length) {
            Map<Character, Integer> freq = new HashMap<Character, Integer>();
            for (int i = i1; i < i1 + length; i++) {
                char c = s1.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            for (int i = i2; i < i2 + length; i++) {
                char c = s2.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) - 1);
            }

            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                int value = entry.getValue();
                if(value != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
