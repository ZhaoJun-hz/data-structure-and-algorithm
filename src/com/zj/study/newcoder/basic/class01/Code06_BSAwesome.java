package com.zj.study.newcoder.basic.class01;

/**
 * 题目描述
 * 一个数组, 无序, 相邻元素不相等, 在小于O(n)的时间复杂度内, 找出一个局部最小值点
 * num[0] < num[1] 0就是局部最小值点
 * num[n - 1] < num[n - 2] n - 1就是局部最小值点
 * num[i - 1] < num[i] < num[i + 1] 0 < i < n - 1
 */
public class Code06_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }
}
