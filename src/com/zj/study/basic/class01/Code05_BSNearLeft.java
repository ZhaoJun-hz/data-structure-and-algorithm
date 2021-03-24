package com.zj.study.basic.class01;

import java.util.Arrays;

public class Code05_BSNearLeft {
    public static int nearLeft(int[] arr, int num) {
        int l = 0, r = arr.length - 1, mid = 0;
        int left = arr.length - 1;
        while (l < r) {
            mid = (l + r) >> 1;
            if (arr[mid] >= num) {
                if (mid < left) {
                    left = mid;
                }
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        if (arr[l] >= num && l < left) {
            left = l;
        }
        return left;
    }

    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr1);
            int nearLeft = nearLeft(arr1, 50);
            int index = nearestIndex(arr1, 50);
            if (! (nearLeft == index)) {
                System.out.println("nearLeft = " + nearLeft +",num = " + arr1[nearLeft]);
                System.out.println("index = " + index + ",num =" + arr1[index]);
                printArray(arr1);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
