package com.zj.study.leetcode.array;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/</a>
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 思路, 数组 双指针
 *
 * @author zj
 * @desiription:
 * @date 2021/4/6 9:09 上午
 */
public class Problem26 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int result;

        nums = new int[]{1,1,2};
        result = solution.removeDuplicates(nums);
        System.out.println(result + 1);
        for (int i = 0; i <= result; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("-----------------");

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        result = solution.removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i <= result; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("-----------------");

    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] != nums[index]) {
                    nums[++index] = nums[i];
                }
            }
            return index + 1;
        }
    }
}
