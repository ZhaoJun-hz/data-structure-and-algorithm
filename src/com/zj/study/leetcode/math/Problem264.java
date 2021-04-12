package com.zj.study.leetcode.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/11 9:53 下午
 */
public class Problem264 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1));
        System.out.println(solution.nthUglyNumber(10));
        System.out.println(solution.nthUglyNumber(1407));

    }

    private static class Solution {
        public int nthUglyNumber(int n) {
            int[] factors = new int[]{2,3,5};
            Set<Long> nums = new HashSet<>();
            PriorityQueue<Long> numsQueue = new PriorityQueue<>();
            nums.add(1L);
            numsQueue.add(1L);

            for (int i = 1; i < n; i++) {
                Long poll = numsQueue.poll();
                for (int j = 0; j < factors.length; j++) {
                    if (!nums.contains(poll * factors[j])) {
                        nums.add(poll * factors[j]);
                        numsQueue.add(poll * factors[j]);
                    }
                }
            }
            return numsQueue.peek().intValue();
        }
    }
}
