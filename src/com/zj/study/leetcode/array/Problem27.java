package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/19 9:07 上午
 */
public class Problem27 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int val;
        int length;
        nums = new int[]{3,2,2,3};
        val = 3;
        length = solution.removeElement(nums, val);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        length = solution.removeElement(nums, val);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();


    }

    private static class Solution {
        public int removeElement(int[] nums, int val) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != val) {
                    nums[index++] = nums[i];
                }
            }
            return index;
        }
    }
}
