package com.zj.study.love.class6_BinarySearchTree;


import java.util.Comparator;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/16 5:26 下午
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        Integer data[] = new Integer[] {7, 4, 9, 2, 5, 8, 11, 3, 13,15, 16};
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        for (int i = 0; i < data.length; i++) {
            searchTree.add(data[i]);
        }
        // List<Integer> result = new ArrayList<>();
        // searchTree.preorderTraversal(integer -> result.add(integer));
        // System.out.println(result);
        // result.clear();
        // System.out.println("------------");
        // searchTree.inorderTraversal(integer -> result.add(integer));
        // System.out.println(result);
        // result.clear();
        // System.out.println("------------");
        // searchTree.postorderTraversal(integer -> result.add(integer));
        // System.out.println(result);
        // result.clear();
        // System.out.println("------------");
        // searchTree.levelOrderTraversal(element -> System.out.println(element * 3));
        // System.out.println("-----println-------");
        System.out.println(searchTree);
        // System.out.println("------------");
        // System.out.println(searchTree.height());
        // System.out.println("------------");
        // System.out.println(searchTree.heightLevelOrderTraversal());
        searchTree.remove(7);
        System.out.println(searchTree);
    }
}
