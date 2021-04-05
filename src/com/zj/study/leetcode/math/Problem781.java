package com.zj.study.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/4 9:19 上午
 */
public class Problem781 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers;

        answers = new int[]{1, 1, 1};
        System.out.println(solution.numRabbits(answers));

        answers = new int[]{1, 1, 2};
        System.out.println(solution.numRabbits(answers));

        answers = new int[]{10, 10, 10};
        System.out.println(solution.numRabbits(answers));

        answers = new int[]{};
        System.out.println(solution.numRabbits(answers));
    }

    private static class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int num : answers) {
                temp.put(num, temp.getOrDefault(num, 0) + 1);
            }
            int result = 0;
            for(Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                int a1 = value / (key + 1);
                int a2 = value % (key + 1);
                result += a1 * (key + 1);
                if (a2 != 0) {
                    result += (key + 1);
                }
            }
            return result;
        }
    }
}
