package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/xor-operation-in-an-array/</a>
 * <p>
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * 思路: 模拟 + 位运算
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 4:17 下午
 */
public class Problem1486 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.xorOperation(5, 0));
        System.out.println(solution.xorOperation(4, 3));
        System.out.println(solution.xorOperation(1, 7));
        System.out.println(solution.xorOperation(10, 5));

    }

    private static class Solution {
        public int xorOperation(int n, int start) {
            int result = start;
            for (int i = 1; i < n; i++) {
                result = result ^ (start + 2 * i);
            }
            return result;
        }
    }
}
