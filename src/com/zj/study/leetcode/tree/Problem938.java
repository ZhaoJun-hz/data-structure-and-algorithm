package com.zj.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/19 7:04 下午
 */
public class Problem938 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            int result = 0;
            Deque<TreeNode> stack = new LinkedList<>();
           TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    if(node.val>= low && node.val <= high) {
                        result += node.val;
                    }
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            return result;
        }
    }

    public static class TreeNode {
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
