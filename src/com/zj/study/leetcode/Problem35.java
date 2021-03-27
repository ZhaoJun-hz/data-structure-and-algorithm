package com.zj.study.leetcode;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/search-insert-position/</a>
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 思路:二分
 *
 * @author zj
 * @desiription:
 * @date 2021/3/26 9:55 上午
 */
public class Problem35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));

        nums = new int[]{1, 3, 5, 6};
        target = 2;
        System.out.println(solution.searchInsert(nums, target));

        nums = new int[]{1, 3, 5, 6};
        target = 7;
        System.out.println(solution.searchInsert(nums, target));

        nums = new int[]{1,3,5,6};
        target = 0;
        System.out.println(solution.searchInsert(nums, target));
    }

    private static class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            int mid;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] == target) {
                    // 如果找到了, 直接返回
                    return mid;
                } else if (nums[mid] > target) {
                    // 如果大于目标值, 右移
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    // 如果目标小于目标值, 左移
                    l = mid + 1;
                }
            }
            // 到这里没有找到target, 那么l的的位置就是其插入的位置
            return l;
        }
    }
}
