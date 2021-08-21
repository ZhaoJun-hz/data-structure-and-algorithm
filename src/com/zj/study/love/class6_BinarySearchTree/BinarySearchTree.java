package com.zj.study.love.class6_BinarySearchTree;

import java.util.Comparator;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/16 4:53 下午
 */
public class BinarySearchTree<E> extends BinaryTree<E>{

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
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
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;
        // 删除度为2的节点
        if (node.hasTwoChild()) {
            // 找到后继节点
            Node<E> successor = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = successor.element;
            // 删除后继节点
            node = successor;
        }
        // 删除度为0或者1的节点
        Node<E> replacement = node.left != null ? node.left : node.right;
        // node 是度为1的节点
        if (replacement != null) {
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left 或者 right的
            if (node.parent == null) {
                // node 是度为1的根节点
                root = replacement;
            } else if (node == node.parent.right) {
                node.parent.right = replacement;
            } else {
                node.parent.left = replacement;
            }
        } else {
            if (node.parent == null) {
                // node 是根节点
                root = null;
            } else {
                // node 是叶子节点
                if (node == node.parent.right) {
                    node.parent.right = null;
                } else {
                    node.parent.left = null;
                }
            }
        }
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    public boolean contains(E element) {
        Node<E> node = node(element);
        return node != null;
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
}
