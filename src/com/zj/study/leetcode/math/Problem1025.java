package com.zj.study.leetcode.math;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/divisor-game/</a>
 * <p>
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一 x，满足 0 < x < N 且 N % x == 0。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 *
 * 思路:
 *
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 3:57 下午
 */
public class Problem1025 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divisorGame(2));
        System.out.println(solution.divisorGame(3));
    }

    private static class Solution {
        public boolean divisorGame(int n) {
            return (n & 1) == 0;
        }
    }
}
