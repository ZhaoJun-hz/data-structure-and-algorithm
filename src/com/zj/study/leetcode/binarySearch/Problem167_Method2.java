package com.zj.study.leetcode.binarySearch;

import java.util.Arrays;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/</a>
 * <p>
 * 给定一个已按照升序排列的整数数组 numbers，请你从数组中找出两个数满足相加之和等于目标数 target。
 * 函数应该以长度为2的整数数组的形式返回这两个数的下标值。numbers 的下标从 1 开始计数，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 思路: 快慢指针
 *
 * @author zj
 * @date 2021/3/25 1:54 下午
 */
public class Problem167_Method2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] numbers = {2,7,11,15};
        // int target = 9;

        // int[] numbers = {2,3,4};
        // int target = 6;

        // int[] numbers = {-1,0};
        // int target = -1;

        // int[] numbers = {5, 25, 75};
        // int target = 100;

        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int index1 = -1, index2 = -1;
            for (int i = 0, j = numbers.length - 1; i < j; ) {
                if (numbers[i] + numbers[j] == target) {
                    index1 = i;
                    index2 = j;
                    break;
                } else if (numbers[i] + numbers[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return new int[]{index1 + 1, index2 + 1};
        }
    }
}
