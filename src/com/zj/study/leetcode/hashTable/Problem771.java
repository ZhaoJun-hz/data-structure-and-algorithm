package com.zj.study.leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/14 10:59 下午
 */
public class Problem771 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String jewels;
        String stones;
        jewels = "aA";
        stones = "aAAbbbb";
        System.out.println(solution.numJewelsInStones(jewels, stones));
        jewels = "z";
        stones = "ZZ";
        System.out.println(solution.numJewelsInStones(jewels, stones));
    }

    private static class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> j = new HashSet<>();
            for (int i = 0; i < jewels.length(); i++) {
                j.add(jewels.charAt(i));
            }
            int result  = 0;
            for (int i = 0; i < stones.length(); i++) {
                if(j.contains(stones.charAt(i))) {
                    result ++;
                }
            }
            return result;
        }
    }
}
