package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Previous Permutation With One Swap
 * -----------------------------------------------------------------------------
 * Given an array A of positive integers (not necessarily distinct), return the lexicographically largest permutation that is smaller than A, that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).  If it cannot be done, then return the same array.
 *
 * Example:
 *      Example 1
 *      Input: [3,2,1]
 *      Output: [3,1,2]
 *      Explanation: Swapping 2 and 1.
 *      Example 2
 *      Input: [1,1,5]
 *      Output: [1,1,5]
 *      Explanation: This is already the smallest permutation.
 *      Example 3
 *      Input: [1,9,4,6,7]
 *      Output: [1,7,4,6,9]
 *      Explanation: Swapping 9 and 7.
 *      Example 4
 *      Input: [3,1,1,3]
 *      Output: [1,3,1,3]
 *      Explanation: Swapping 1 and 3.
 *      Note:
 *      	1 <= A.length <= 10000
 *      	1 <= A[i] <= 10000
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/previous-permutation-with-one-swap/
 * @since   2020-04-19 13:35:24
 */
public class L1139_Previous_Permutation_With_One_Swap {
    static class Solution {
        public int[] prevPermOpt1(int[] nums) {
            // 从右往左 找到第一个 a[k] > a[k+1]
            int k = -1;
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i-1] > nums[i]) {
                    k = i-1;
                    break;
                }
            }
            // 交换字典序中刚好小于于边界的元素
            if (k == -1) return nums;
            int l = -1;
            for (int i = nums.length - 1; i > k; i --) {
                if (nums[i] < nums[k]) {
                    if (l != -1 && nums[l] > nums[i]) {
                        break;
                    }
                    l = i;
                }
            }
            swap(nums, k, l);
            return nums;
        }
        // 交换
        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
