package com.zj.study.leetcode.binarySearch;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/7 7:16 上午
 */
public class Problem81 {

    public static void main(String[] args) {
        int[] nums;
        int target;
        Solution solution = new Solution();

        nums = new int[]{2,5,6,0,0,1,2};
        target = 0;
        System.out.println(solution.search(nums, target));

        nums = new int[]{2,5,6,0,0,1,2};
        target = 3;
        System.out.println(solution.search(nums, target));

        nums = new int[]{0};
        target = 3;
        System.out.println(solution.search(nums, target));
    }

    private static class Solution {
        public boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            return search(l, r, target, nums);
        }

        private boolean search(int l, int r, int target, int[] nums) {
            if (l > r) {
                return false;
            }
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            boolean search1 = search(l, mid - 1, target, nums);
            boolean search2 = search(mid + 1, r, target, nums);
            if (search1) {
                return search1;
            }
            if (search2) {
                return search2;
            }
            return false;
        }
    }
}
