package com.zj.study.leetcode.interview;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/volume-of-histogram-lcci/</a>
 * <p>
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * 思路: 动态规划
 * 下标i位置,所能达到的高度为左边和右边所能达到的高度的最小值, 所能装水的量为所能达到的高度减去本身的高度
 * leftMax 代表左边所能达到的最大值
 * rightMax 代表右边所能达到高度的最大值
 *
 * @author zj
 * @desiription:
 * @date 2021/4/2 6:48 上午
 */
public class Problem17_21_Method1 {
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
