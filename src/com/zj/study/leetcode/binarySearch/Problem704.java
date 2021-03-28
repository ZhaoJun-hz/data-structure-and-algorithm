package com.zj.study.leetcode.binarySearch;

public class Problem704 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = {-1,0,3,5,9,12};
        // int target = 9;

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(solution.search(nums, target));
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            int mid;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -1;
        }
    }
}
