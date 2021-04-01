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
 * 思路: 暴力
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 9:19 上午
 */
public class Problem78_Method2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[] {1,2,3};
        System.out.println(solution.subsets(nums));
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) { // 有 2 ^ n个子集
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> temp = new ArrayList<>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
            return result;
        }
    }
}
