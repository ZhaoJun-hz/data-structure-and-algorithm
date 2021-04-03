package com.zj.study.leetcode.array;

import com.zj.study.leetcode.interview.Problem17_21_Method1;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/2 11:46 上午
 */
public class Problem42 {
    public static void main(String[] args) {
        int[] height;
        Solution solution = new Solution();

        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }


    private static class Solution {
        public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            for (int i = 0; i < height.length; i++) {
                if (i == 0) leftMax[i] = height[i];
                else leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            for (int i = height.length - 1; i >= 0; i--) {
                if (i == height.length - 1) rightMax[i] = height[i];
                else rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                result = result + Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return result;
        }
    }
}
