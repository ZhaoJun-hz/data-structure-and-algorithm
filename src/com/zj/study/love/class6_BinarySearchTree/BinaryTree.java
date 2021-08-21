package com.zj.study.love.class6_BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/21 8:33 下午
 */
public class BinaryTree<E>{
    protected int size = 0;
    protected Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 前序遍历二叉树
     *
     * @param visitor
     */
    public void preorderTraversal(Visitor<E> visitor) {
        preorderTraversal(root, visitor);
    }

    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    /**
     * 中序遍历二叉树
     *
     * @param visitor
     */
    public void inorderTraversal(Visitor<E> visitor) {
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        inorderTraversal(node.left, visitor);
        visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    /**
     * 层次遍历树
     *
     * @param visitor
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null || visitor == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 后续遍历二叉树
     *
     * @param visitor
     */
    public void postorderTraversal(Visitor<E> visitor) {
        postorderTraversal(root, visitor);
    }

    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        visitor.visit(node.element);
    }

    protected Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }

        // 前驱结点在左子树中
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点,祖父加点寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    protected Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }

        // 前驱结点在右子树中
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 从父节点,祖父加点寻找后继节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 递归获取树的高度
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 层次遍历获取树的高度
     *
     * @return
     */
    public int heightLevelOrderTraversal() {
        if (root == null) {
            return 0;
        }

        int height = 0;
        // 存储着每一行的元素的数量
        int rowSize = 1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            rowSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (rowSize == 0) {
                rowSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 判断一棵树是不是完全二叉树
     * <p>
     * 如果树为空,返回false
     * <p>
     * 如果树不为空,开始使用层次遍历二叉树,使用队列
     * 如果node.left != null && node.right != null, 将node.left 和 node.right 按顺序入队
     * 如果node.left == null && node.right != null, 返回false
     * 如果node.left != null && node.right == null  或者 node.left == null && node.right == null, 那么后面遍历的节点应该都是叶子节点, 才是完全二叉树, 否则返回false
     *
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) {
                return false;
            }
            if (node.hasTwoChild()) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else {
                // 后面节点全部是叶子节点
                leaf = true;
            }
        }
        return true;
    }


    public static interface Visitor<E> {
        void visit(E e);
    }

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChild() {
            return left != null && right != null;
        }
    }
}
