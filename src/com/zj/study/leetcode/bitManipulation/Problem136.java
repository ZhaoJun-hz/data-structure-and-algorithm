package com.zj.study.leetcode.bitManipulation;

/**
 * <a>https://leetcode-cn.com/problems/single-number/</a>
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 思路 位运算 异或
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 3:03 下午
 */
public class Problem136 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2,2,1};
        System.out.println(solution.singleNumber(nums));
        nums = new int[]{4,1,2,1,2};
        System.out.println(solution.singleNumber(nums));
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            // for (int i = 1; i < nums.length; i++) {
            //     nums[i] = nums[i] ^ nums[i - 1];
            // }
            // return nums[nums.length - 1];
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
}
