package com.zj.study.leetcode.math;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/number-of-good-pairs/</a>
 *
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 *
 * 思路: 双层for 循环
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 1:51 下午
 */
public class Problem1512_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        nums = new int[]{1,2,3,1,1,3};
        System.out.println(solution.numIdenticalPairs(nums));
        nums = new int[] {1,1,1,1};
        System.out.println(solution.numIdenticalPairs(nums));
        nums = new int[] {1,2,3};
        System.out.println(solution.numIdenticalPairs(nums));
    }

    private static class Solution {
        public int numIdenticalPairs(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[i] == nums[j]) {
                        result ++;
                    }
                }
            }
            return result;
        }
    }
}
