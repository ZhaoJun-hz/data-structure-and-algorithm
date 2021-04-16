package com.zj.study.leetcode.array;

import java.util.HashMap;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 12:06 下午
 */
public class Problem1 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {

            HashMap<Integer,Integer> map  = new HashMap<>();
            //一次遍历
            for (int i = 0; i < nums.length; ++i) {
                //存在时，我们用数组得值为 key，索引为 value
                if (map.containsKey(target - nums[i])){
                    return new int[]{i,map.get(target-nums[i])};
                }
                //存入值
                map.put(nums[i],i);
            }
            //返回
            return new int[]{};
        }
    }
}
