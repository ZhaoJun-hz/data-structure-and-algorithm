package com.zj.study.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/20 3:06 下午
 */
public class Problem104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        int rowSize = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            rowSize --;
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            if(rowSize == 0) {
                rowSize = queue.size();
                height ++;
            }
        }
        return height;
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
