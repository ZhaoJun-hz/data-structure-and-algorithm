package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 11:13 上午
 */
public class Problem1295 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{12,345,2,6,7896};
        System.out.println(solution.findNumbers(nums));

        nums = new int[]{555,901,482,1771};
        System.out.println(solution.findNumbers(nums));
    }

    private static class Solution {
        public int findNumbers(int[] nums) {
            int result = 0;
            for (int num : nums) {
                if (num >= 10 && num < 100) {
                    result ++;
                }else if (num >= 1000 && num < 10000) {
                    result ++;
                }else if (num >= 100000 && num <1000000) {
                    result ++;
                }
            }
            return result;
        }
    }
}
