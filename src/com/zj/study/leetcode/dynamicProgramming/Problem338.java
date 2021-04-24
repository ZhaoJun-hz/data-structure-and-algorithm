package com.zj.study.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/23 4:15 下午
 */
public class Problem338 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(Arrays.toString(solution.countBits(0)));
        // System.out.println(Arrays.toString(solution.countBits(1)));
        // System.out.println(Arrays.toString(solution.countBits(2)));
        // System.out.println(Arrays.toString(solution.countBits(3)));
        // System.out.println(Arrays.toString(solution.countBits(4)));
        // System.out.println(Arrays.toString(solution.countBits(5)));
        System.out.println(Arrays.toString(solution.countBits(6)));
        System.out.println(Arrays.toString(solution.countBits(7)));
    }

    private static class Solution {
        public int[] countBits(int num) {
            if(num == 0) return new int[]{0};
            if(num == 1) return new int[]{0, 1};
            if(num == 2) return new int[]{0, 1, 1};
            int[] result = new int[num + 1];
            result[0] = 0;
            result[1] = 1;
            result[2] = 1;
            int temp = 2;
            for (int i = 3, j = 1; i <= num ; i++, j++) {
                if(j == temp) {
                    result[i] = 1;
                    temp *= 2;
                    j = 0;
                }else {
                    result[i] = result[temp] + result[j];
                }
            }
            return result;
        }
    }
}
