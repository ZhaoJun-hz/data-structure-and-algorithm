package com.zj.study.leetcode.sort;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/2 6:36 下午
 */
public class Problem1528 {

    public static void main(String[] args) {
        String s;
        int[] indices;
        Solution solution = new Solution();

        s = "codeleet";
        indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(solution.restoreString(s, indices));

    }

    private static class Solution {
        public String restoreString(String s, int[] indices) {
            char[] result = new char[s.length()];
            for (int i = 0; i < indices.length; i++) {
                result[indices[i]] = s.charAt(i);
            }
            return new String(result);
        }
    }
}
