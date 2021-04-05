package com.zj.study.leetcode.string;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/4 9:53 下午
 */
public class Problem5722 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        int k;
        s = "Hello how are you Contestant";
        k = 4;
        System.out.println(solution.truncateSentence(s, 4));
    }

    private static class Solution {
        public String truncateSentence(String s, int k) {
            String[] s1 = s.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < k; i++) {
                stringBuilder.append(" " + s1[i]);
            }
            return stringBuilder.toString().substring(1);
        }
    }
}
