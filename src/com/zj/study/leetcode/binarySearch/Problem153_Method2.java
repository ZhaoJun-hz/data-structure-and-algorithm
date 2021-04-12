package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 4:57 下午
 */
public class Problem153_Method2 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums));
        nums = new int[]{1, 3, 5};
        System.out.println(solution.findMin(nums));
        nums = new int[]{2, 2, 2, 0, 1};
        System.out.println(solution.findMin(nums));
        nums = new int[]{1, 3, 3};
        System.out.println(solution.findMin(nums));
    }

    private static class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1, mid;
            // low<high，假如最后循环到{*,10,1,*}的这种情况时，nums[low]=10,nums[high]=1,nums[mid]=10,low=mid+1,
            // 直接可以跳出循环了,所以low<high,此时low指向的就是最小值的下标;
            // 如果low<=high的话，low=high，还会再不必要的循环一次，此时最后一次循环的时候会发生low==high==mid，
            // 则nums[mid]==nums[high]，则会走一次else语句，则low=mid+1,此时low指向的是最小值的下一个下标，
            // 则需要return[low-1]
            while (l < r) {
                mid = l + ((r - l) >> 1);
                // 如果中间值小于最大值，则最大值减小
                // {4,5,1,2,3}，如果high=mid-1，则丢失了最小值1
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    // 如果中间值大于最大值，则最小值变大
                    // 为什么 low = mid+1;而不是 low = mid;
                    // 难道没有可能low=mid+1,正好错过了最小值
                    // 如果nums[mid]是最小值的话，则其一定小于nums[high],走if，就不会走else了
                    l = mid + 1;
                }
            }
            return nums[l];
        }
    }
}
