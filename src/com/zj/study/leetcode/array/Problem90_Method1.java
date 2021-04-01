package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/subsets-ii/</a>
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 思路: 位运算 , 中间结果排序, Set去重
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 9:20 上午
 */
public class Problem90_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[] {1,2,2};
        System.out.println(solution.subsetsWithDup(nums));

        nums = new int[] {4,4,4,1,4};
        System.out.println(solution.subsetsWithDup(nums));
    }

    private static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < (1 << nums.length); i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    if(((i >> j) & 1) == 1) {
                        temp.add(nums[j]);
                    }
                }
                Collections.sort(temp);
                result.add(temp);
            }
            return new ArrayList<>(result);
        }
    }
}
