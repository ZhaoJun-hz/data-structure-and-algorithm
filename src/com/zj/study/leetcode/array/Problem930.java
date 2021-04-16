package com.zj.study.leetcode.array;

import java.util.HashMap;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 2:20 下午
 */
public class Problem930 {
    public static void main(String[] args) {
        int[] nums;
        int k;
        Solution solution = new Solution();
        nums = new int[]{1,0,1,0,1};
        k = 2;
        System.out.println(solution.numSubarraysWithSum(nums, k));

        // nums = new int[]{1,2,3};
        // k = 3;
        // System.out.println(solution.numSubarraysWithSum(nums, k));
    }

    private static class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            if (A.length == 0) {
                return 0;
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
            //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
            //输入：[3,1,1,0] k = 2时则不会漏掉
            //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
            map.put(0, 1);
            int count = 0;
            int presum = 0;
            for (int x : A) {
                presum += x;
                //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
                if (map.containsKey(presum - S)) {
                    count += map.get(presum - S);//获取次数
                }
                //更新
                map.put(presum,map.getOrDefault(presum,0) + 1);
            }
            return count;
        }
    }
}
