package com.zj.study.leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/binary-watch/</a>
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 5:31 下午
 */
public class Problem401 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.readBinaryWatch(1));
        System.out.println(solution.readBinaryWatch(2));
    }

    private static class Solution {
        public List<String> readBinaryWatch(int num) {
            List<String> result = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    int oneNumber = Integer.bitCount(i) + Integer.bitCount(j);
                    if (oneNumber == num) {
                        builder.delete(0, builder.length());
                        builder.append(i);
                        builder.append(":");
                        if (j < 10) {
                            builder.append(0);
                        }
                        builder.append(j);
                        result.add(builder.toString());
                    }
                }
            }
            return result;
        }
    }
}
