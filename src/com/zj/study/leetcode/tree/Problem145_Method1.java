package com.zj.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/13 7:54 上午
 */
public class Problem145_Method1 {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    private static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.val);
        }
    }

    private static class TreeNode {
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
