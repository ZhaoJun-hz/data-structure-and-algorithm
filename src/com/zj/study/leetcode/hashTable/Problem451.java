package com.zj.study.leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/27 10:02 上午
 */
public class Problem451 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
    }

    private static class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> values = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char tempChar = s.charAt(i);
                values.put(tempChar, values.getOrDefault(tempChar, 0) + 1);
            }
            List<Character>[] buckets = new List[s.length() + 1];
            for(Character character : values.keySet()) {
                int value = values.get(character);
                if(buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(character);
            }

            StringBuilder result = new StringBuilder();
            for (int i = buckets.length - 1; i > 0 ; i--) {
                if(buckets[i] != null) {
                    for (Character c : buckets[i]) {
                        for (int j = 0; j < i; j++) {
                            result.append(c);
                        }
                    }
                }
            }
            return result.toString();
        }
    }
}
