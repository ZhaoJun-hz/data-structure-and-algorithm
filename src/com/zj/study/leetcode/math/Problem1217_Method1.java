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
 * 思路: 记录每个位置有多少筹码, 然后遍历求移动的最小值
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 11:16 上午
 */
public class Problem1217_Method1 {
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
            Map<Integer, Integer> temp = new HashMap<>();
            for (int num : position) {
                temp.put(num, temp.getOrDefault(num, 0) + 1);
            }
            int[][] tempArray = new int[temp.size()][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                tempArray[index][0] = entry.getKey();
                tempArray[index][1] = entry.getValue();
                index++;
            }
            int min = Integer.MAX_VALUE;
            int tempSum = 0;
            for (int i = 0; i < temp.size(); i++) {
                tempSum = 0;
                for (int j = 0; j < temp.size(); j++) {
                    if (i != j) {
                        if (((tempArray[j][0] - tempArray[i][0]) & 1) == 1) {
                            tempSum += tempArray[j][1];
                        }
                    }
                }
                if (tempSum < min) {
                    min = tempSum;
                }
            }
            return min;
        }
    }

}
