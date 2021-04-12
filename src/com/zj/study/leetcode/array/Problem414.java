package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/9 4:55 下午
 */
public class Problem414 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        // nums = new int[]{3, 2, 1};
        // System.out.println(solution.thirdMax(nums));
        // nums = new int[]{1,2};
        // System.out.println(solution.thirdMax(nums));
        nums = new int[]{2,2,3,1};
        System.out.println(solution.thirdMax(nums));
    }

    private static class Solution {
        public int thirdMax(int[] nums) {
            Integer min = null, middle = null, max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    min = middle;
                    middle = max;
                    max = nums[i];
                }else if (nums[i] < max) {
                    if(middle == null) {
                        middle = nums[i];
                    }else {
                        if (nums[i] > middle) {
                            min = middle;
                            middle = nums[i];
                        }else if(nums[i] < middle){
                            if(min == null) {
                                min = nums[i];
                            }else {
                                if(nums[i] > min) {
                                    min = nums[i];
                                }
                            }
                        }
                    }
                }
            }
            return min == null ? max : min;
        }
    }
}
