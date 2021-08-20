package com.zj.study.love.class6_BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/16 4:53 下午
 */
public class BinarySearchTree<E> {

    private int size = 0;
    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    /**
     * 二叉搜索树中添加元素
     *
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                // 相等, 新的替换旧的
                node.element = element;
                return;
            }
        }
        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
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

    /**
     * 层次遍历树的高度
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
            rowSize --;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (rowSize == 0) {
                rowSize = queue.size();
                height ++;
            }
        }
        return height;
    }

    /**
     * 判断一棵树是不是完全二叉树
     *
     * 如果树为空,返回false
     *
     * 如果树不为空,开始使用层次遍历二叉树,使用队列
     * 如果node.left != null && node.right != null, 将node.left 和 node.right 按顺序入队
     * 如果node.left == null && node.right != null, 返回false
     * 如果node.left != null && node.right == null  或者 node.left == null && node.right == null, 那么后面遍历的节点应该都是叶子节点, 才是完全二叉树
     *
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }



        }
        return false;
    }

    /**
     * @param e1
     * @param e2
     * @return 等于0, 代表e1和e2相等, 返回值大于0,代表e1大于e2, 返回值小于0,代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) {
            return;
        }
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb, prefix + "[L]");
        toString(node.right, sb, prefix + "[R]");
    }

    public static interface Visitor<E> {
        void visit(E e);
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
