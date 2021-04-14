package com.zj.study.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/13 3:36 下午
 */
public class Problem530 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int getMinimumDifference(TreeNode root) {
            List<Integer> integers = inorderTraversal(root);
            int min = integers.get(1) - integers.get(0);
            for (int i = 2; i < integers.size(); i++) {
                int temp = integers.get(i) - integers.get(i - 1);
                if (temp < min) {
                    min = temp;
                }
            }
            return min;
        }

        private List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }

        private void inorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
