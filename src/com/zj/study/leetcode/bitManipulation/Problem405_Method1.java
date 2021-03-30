package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/</a>
 * <p>
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 9:37 上午
 */
public class Problem405_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
        System.out.println(solution.toHex(16));
    }

    private static class Solution {
        public String toHex(int num) {
            if (num == 0) return "0";
            String result = "";
            for (int i = 32; i > 0; i -= 4) {
                String temp = getString((num >> (i - 1)) & 1, (num >> (i - 2)) & 1, (num >> (i - 3)) & 1, (num >> (i - 4)) & 1);
                if ("".equals(result)) {
                    if (!"0".equals(temp)) {
                        result += temp;
                    }
                } else {
                    result += temp;
                }
            }
            return result;
        }

        private String getString(int i1, int i2, int i3, int i4) {
            int result = i1 * 8 + i2 * 4 + i3 * 2 + i4;
            switch (result) {
                case 0:
                    return "0";
                case 1:
                    return "1";
                case 2:
                    return "2";
                case 3:
                    return "3";
                case 4:
                    return "4";
                case 5:
                    return "5";
                case 6:
                    return "6";
                case 7:
                    return "7";
                case 8:
                    return "8";
                case 9:
                    return "9";
                case 10:
                    return "a";
                case 11:
                    return "b";
                case 12:
                    return "c";
                case 13:
                    return "d";
                case 14:
                    return "e";
                case 15:
                    return "f";
            }
            return "";
        }
    }
}
