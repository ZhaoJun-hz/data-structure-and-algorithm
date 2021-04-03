package com.zj.study.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/1 6:41 下午
 */
public class Problem227 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate(" 3/2 "));
        System.out.println(solution.calculate(" 3+5 / 2 "));
    }

    private static class Solution {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 2);
            put('^', 3);
        }};


        public int calculate(String s) {
            // 存放所有的数字
            ArrayDeque<Integer> nums = new ArrayDeque<>();
            // 为了防止第一个数字为负数，先往nums加个0
            nums.addLast(0);
            // 将所有的空格去掉， 并将 （- 替换成 （0- ，（+替换成(0+
            s = s.replaceAll(" ", "");
            s = s.replaceAll("\\(-", "(0-");
            s = s.replaceAll("\\(\\+", "(0+");
            // 存放所有的操作， 包括 + -
            Deque<Character> ops = new ArrayDeque<>();
            int n = s.length();
            char[] cs = s.toCharArray();
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if(c == '(') {
                    ops.addLast(c);
                }else if(c == ')') {
                    // 计算到最近一个左括号为止
                    while (!ops.isEmpty()) {
                        Character op = ops.peekLast();
                        if (op != '(') {
                            calc(nums, ops);
                        }else {
                            ops.pollLast();
                            break;
                        }
                    }
                }else {
                    if (isNum(c)) {
                        int u = 0;
                        int j = i;
                        // 将从 i 为止开始后面的连续数字整体取出，加入nums
                        while (j < n && isNum(cs[j])) u = u * 10 + (int)(cs[j++] - '0');
                        nums.addLast(u);
                        i = j - 1;
                    }else {
                        // 有一个新操作要入栈时，先把栈内可以算的都算了
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            char prev = ops.peekLast();
                            if(map.get(prev) >= map.get(c)) {
                                calc(nums, ops);
                            }else {
                                break;
                            }
                        }
                        ops.addLast(c);
                    }
                }
            }
            while (!ops.isEmpty()) calc(nums, ops);
            return nums.peekLast();
        }

        void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) return;
            if (ops.isEmpty()) return;
            int b = nums.pollLast(), a = nums.pollLast();
            char op = ops.pollLast();
            int ans = 0;
            if (op == '+') {
                ans = a + b;
            } else if (op == '-') {
                ans = a - b;
            } else if (op == '*') {
                ans = a * b;
            } else if (op == '/') {
                ans = a / b;
            } else if (op == '^') {
                ans = (int) Math.pow(a, b);
            } else if (op == '%') {
                ans = a % b;
            }
            nums.add(ans);
        }

        boolean isNum(char c) {
            return Character.isDigit(c);
        }
    }
}



