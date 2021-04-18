package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/17 9:42 上午
 */
public class Problem219 {

    public static void main(String[] args) {
        int[] nums;
        int k;
        Solution solution = new Solution();

        nums = new int[]{1,2,3,1};
        k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k));

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println(solution.containsNearbyDuplicate(nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }


    private static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, List<Integer>> result = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                List<Integer> index = result.getOrDefault(nums[i], new ArrayList<>());
                index.add(i);
                result.put(nums[i], index);
                if(index.size() > 1) {
                    for (int j = 0; j < index.size(); j++) {
                        for (int l = j + 1; l < index.size(); l++) {
                            if(index.get(l) - index.get(j) <= k) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
