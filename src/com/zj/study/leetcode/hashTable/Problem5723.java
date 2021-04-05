package com.zj.study.leetcode.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/4 10:02 下午
 */
public class Problem5723 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] logs;
        int k;
        logs = new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        k = 5;
        System.out.println(Arrays.toString(solution.findingUsersActiveMinutes(logs, k)));

        logs = new int[][]{{1,1},{2,2},{2,3}};
        k = 4;
        System.out.println(Arrays.toString(solution.findingUsersActiveMinutes(logs, k)));

    }

    private static class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            HashMap<Integer, Set<Integer>> temp = new HashMap<>();
            int[] result = new int[k];
            for (int i = 0; i < logs.length; i++) {
                Set<Integer> set = temp.getOrDefault(logs[i][0], new HashSet<>());
                set.add(logs[i][1]);
                temp.put(logs[i][0], set);
            }
            HashMap<Integer, Integer> times = new HashMap<>();
            for (Map.Entry<Integer, Set<Integer>> entry : temp.entrySet()) {
                int size = entry.getValue().size();
                times.put(size, times.getOrDefault(size, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
                result[entry.getKey() - 1] = entry.getValue();
            }
            return result;
        }
    }
}

