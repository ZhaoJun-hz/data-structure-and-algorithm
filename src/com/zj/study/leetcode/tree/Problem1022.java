package com.zj.study.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/20 3:06 下午
 */
public class Problem1022 {

    private static class Node {
        private TreeNode treeNode;
        private int height;
        private int sum;
        public Node(TreeNode treeNode, int height, int sum) {
            this.treeNode = treeNode;
            this.height = height;
            this.sum = sum;
        }
        public TreeNode getTreeNode() {
            return treeNode;
        }
        public int getHeight() {
            return height;
        }
        public int getSum() {
            return sum;
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1, root.val));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // System.out.println("---" + node.sum);
            TreeNode treeNode = node.getTreeNode();
            if (treeNode.left != null) {
                queue.offer(new Node(treeNode.left, node.height + 1, node.sum * 2 + treeNode.left.val));
            }
            if (treeNode.right != null) {
                queue.offer(new Node(treeNode.right, node.height + 1, node.sum * 2 + treeNode.right.val));
            }
            if (treeNode.left == null && treeNode.right == null) {
                // System.out.println(node.sum);
                result += node.getSum();
            }
        }
        return result;
    }
}
