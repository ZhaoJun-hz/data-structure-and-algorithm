package com.zj.study.newcoder.basic.class02;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/2 5:29 下午
 */
public class Code02_SmallSum {
    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 3, 4, 2, 5};
        System.out.println(mergeSort(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int help[] = new int[r - l + 1];
        int i = 0, result = 0;
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            // 这里, 如果两个数相等, 先拷贝右边的数, 要不然不知道右边有多少个数比这个数大
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return result;
    }


}
