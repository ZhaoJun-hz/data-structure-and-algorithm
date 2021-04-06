package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/</a>
 * <p>
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有最多的糖果。注意，允许有多个孩子同时拥有 最多的糖果数目。
 *
 * @author zj
 * @desiription:
 * @date 2021/4/6 9:58 上午
 */
public class Problem1431 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candies;
        int extraCandies;

        candies = new int[]{2, 3, 5, 1, 3};
        extraCandies = 3;
        System.out.println(solution.kidsWithCandies(candies, extraCandies));

    }

    private static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> result = new ArrayList<Boolean>();
            int max = Integer.MIN_VALUE;
            for (int num : candies) {
                if (num > max) {
                    max = num;
                }
            }

            for (int num : candies) {
                if (num + extraCandies >= max) {
                    result.add(true);
                    continue;
                }
                result.add(false);
            }
            return result;
        }
    }
}
