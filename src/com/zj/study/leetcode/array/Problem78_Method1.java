package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/subsets/</a>
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 思路:位运算
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 9:19 上午
 */
public class Problem78_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[] {1,2,3};
        System.out.println(solution.subsets(nums));
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < (1 << nums.length); i++) { // 有 2 ^ n个子集
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    // ((i >> j) & 1) == 1 表示对于二进制数i，从低位到高位逐个取其二进制位，并判断是否为1，若为1则放入对于nums中的元素
                    if(((i >> j) & 1) == 1) {
                        temp.add(nums[j]);
                    }
                }
                result.add(temp);
            }
            return result;
        }
    }
}
