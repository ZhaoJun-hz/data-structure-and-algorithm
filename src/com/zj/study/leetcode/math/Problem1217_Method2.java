package com.zj.study.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/</a>
 * <p>
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 * <p>
 * 思路: 奇数位置移动到奇数位置, 偶数位置移动到偶数位置不需要代价,其他位置移动消耗代价
 *  统计奇数的偶数的数量即可
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 11:16 上午
 */
public class Problem1217_Method2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] position;
        position = new int[]{1, 2, 3};
        System.out.println(solution.minCostToMoveChips(position));
        position = new int[]{1, 2, 2, 2, 2};
        System.out.println(solution.minCostToMoveChips(position));

        position = new int[]{2, 2, 2, 3, 3};
        System.out.println(solution.minCostToMoveChips(position));
    }

    private static class Solution {
        public int minCostToMoveChips(int[] position) {
            int odd = 0, even = 0;
            for (int num : position) {
                if( (num & 1) == 1) {
                    even++;
                }else {
                    odd++;
                }
            }
            return Math.min(odd, even);
        }
    }

}
