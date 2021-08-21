package com.zj.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/13 7:54 上午
 */
public class Problem144_Method1 {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    private static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        private void preorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.val);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }
}
