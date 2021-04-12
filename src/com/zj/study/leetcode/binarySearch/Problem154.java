package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/9 9:25 上午
 */
public class Problem154 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        // nums = new int[]{3, 4, 5, 1, 2};
        // System.out.println(solution.findMin(nums)); // 1
        // nums = new int[]{1, 3, 5};
        // System.out.println(solution.findMin(nums)); // 1
        // nums = new int[]{2, 2, 2, 0, 1};
        // System.out.println(solution.findMin(nums)); // 0
        nums = new int[]{1, 3, 3};
        System.out.println(solution.findMin(nums)); // 1
        nums = new int[]{3, 3, 1, 3};
        System.out.println(solution.findMin(nums)); // 1
    }

    private static class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1, mid;
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r --;
                }
            }
            return nums[l];
        }
    }
}
