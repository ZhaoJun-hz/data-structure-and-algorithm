package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/7 7:16 上午
 */
public class Problem33 {
    public static void main(String[] args) {
        int[] nums;
        int target;
        Solution solution = new Solution();

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        System.out.println(solution.search(nums, target));

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        System.out.println(solution.search(nums, target));

        nums = new int[]{0};
        target = 3;
        System.out.println(solution.search(nums, target));
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            return search(l, r, target, nums);
        }

        private int search(int l, int r, int target, int[] nums) {
            if (l > r) {
                return -1;
            }
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            int search1 = search(l, mid - 1, target, nums);
            int search2 = search(mid + 1, r, target, nums);
            if (search1 != -1) {
                return search1;
            }
            if (search2 != -1) {
                return search2;
            }
            return -1;
        }
    }
}
