package com.zj.study.leetcode.array;


import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/17 10:01 上午
 */
public class Problem220 {

    public static void main(String[] args) {
        int[] nums;
        int k, t;
        Solution solution = new Solution();

        // nums = new int[]{1,2,3,1};
        // k = 3;
        // t = 0;
        // System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        //
        // nums = new int[]{1,0,1,1};
        // k = 1;
        // t = 2;
        // System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        //
        // nums = new int[]{1,5,9,1,5,9};
        // k = 2;
        // t = 3;
        // System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        //
        // nums = new int[]{-2147483648,2147483647};
        // k = 1;
        // t = 1;
        // System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        //
        // nums = new int[]{0,10,22,15,0,5,22,12,1,5};
        // k = 3;
        // t = 3;
        // System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));

        nums = new int[]{1, 3, 6, 2};
        k = 1;
        t = 2;
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }
    private static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            long[][] newNums = new long[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                newNums[i][0] = nums[i];
                newNums[i][1] = i;
            }

            Arrays.sort(newNums, (event1, event2) -> (int) (event1[0] == event2[0] ? event1[1] - event2[1] : event1[0] - event2[0]));

            for (int i = 0; i < newNums.length; i++) {
                for (int j = i + 1; j < newNums.length; j++) {
                    long diff = Math.abs(newNums[j][0] - newNums[i][0]);
                    if(diff <= t) {
                        if(Math.abs(newNums[j][1] - newNums[i][1]) <= k) {
                            return true;
                        }else {
                            continue;
                        }
                    }else {
                        break;
                    }
                }
            }
            return false;
        }
    }
}
