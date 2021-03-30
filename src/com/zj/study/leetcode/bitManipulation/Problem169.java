package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/majority-element/</a>
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 思路:
 * Boyer-Moore 算法的详细步骤：
 * 我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
 * 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
 * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
 * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
 * 在遍历完成后，candidate 即为整个数组的众数。
 *
 * 投票算法证明：
 *
 * 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
 * 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 6:07 下午
 */
public class Problem169 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{3, 2, 3};
        System.out.println(solution.majorityElement(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums));
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;
            for(int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += num == candidate ? 1 : -1;
            }
            return candidate;
        }
    }
}
