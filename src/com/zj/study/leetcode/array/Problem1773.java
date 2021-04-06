package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 11:00 上午
 */
public class Problem1773 {

    public static void main(String[] args) {
        String ruleKey;
        String ruleValue;
        List<List<String>> items = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Solution solution = new Solution();

        items = new ArrayList<>();
        solution = new Solution();
        temp.add("phone");
        temp.add("blue");
        temp.add("pixel");
        items.add(temp);
        temp = new ArrayList<>();
        temp.add("computer");
        temp.add("silver");
        temp.add("lenovo");
        items.add(temp);
        temp = new ArrayList<>();
        temp.add("phone");
        temp.add("gold");
        temp.add("iphone");
        items.add(temp);
        ruleKey = "color";
        ruleValue = "silver";
        System.out.println(solution.countMatches(items, ruleKey, ruleValue));
    }

    private static class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int result = 0;
            int ruleIndex = 0;
            if ("type".equals(ruleKey)) {
                ruleIndex = 0;
            }else if ("color".equals(ruleKey)) {
                ruleIndex = 1;
            }else if("name".equals(ruleKey)) {
                ruleIndex = 2;
            }

            for (List<String> temp : items) {
                if(temp.get(ruleIndex).equals(ruleValue)) {
                    result ++;
                }
            }
            return result;
        }
    }
}
