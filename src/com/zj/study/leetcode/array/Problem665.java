package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 8:11 下午
 */
public class Problem665 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();

        nums = new int[]{4, 2, 3};
        System.out.println(solution.checkPossibility(nums)); // true
        nums = new int[]{4, 2, 1};
        System.out.println(solution.checkPossibility(nums)); // false
        nums = new int[]{3, 4, 2, 3};
        System.out.println(solution.checkPossibility(nums)); // false
        nums = new int[]{1, 1, 1};
        System.out.println(solution.checkPossibility(nums)); // true
    }

    private static class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return true;
            }

            // 4 2 5 如果是第一个数不满足, 则让第一个数等于第二个数
            // 1 4 2 5 对于2, 2大于1, 所以只能让4 变成 2
            // 3 4 2 5 对于2, 3大于2, 2只能变成4
            int cnt = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    if (i == 1 || nums[i] >= nums[i - 2]) {
                        nums[i - 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                    if (++cnt > 1) {
                        return false;
                    }
                }

            }
            return true;
        }
    }
}
