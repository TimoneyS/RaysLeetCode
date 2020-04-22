package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Split Array Largest Sum
 * -----------------------------------------------------------------------------
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples: 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/split-array-largest-sum/
 * @since   2020-04-22 22:34:28
 */
public class L0410_Split_Array_Largest_Sum {
    /**
     * dp[i][j] 表示 从 i 开始分割为 j 个数组的最优解
     *  dp[0][j] =  Min { Max(sum[0, i], dp[i][j]), .. } i = (0, nums.length)
     */
    static class Solution {
        public int splitArray(int[] nums, int m) {
            long[] sum = new long[nums.length];
            for (int i = 0; i < sum.length; i ++) {
                sum[i] = nums[i] + (i == 0 ? 0 : sum[i-1]);
            }
            int[][] mem = new int[nums.length][m+1];
            return splitArray(0, m, sum, mem);
        }

        private int splitArray(int start, int m, long[] sum, int[][] mem) {
            if (mem[start][m] == 0) {
                if (m == 1) {
                    mem[start][m] = (int) (sum[sum.length - 1] - (start == 0 ? 0 : sum[start - 1]));
                } else {
                    mem[start][m] = Integer.MAX_VALUE;
                    for (int i = start; i + m <= sum.length; i++) {
                        int curr = (int) (sum[i] - (start == 0 ? 0 : sum[start - 1]));

                        int t = splitArray(i + 1, m - 1, sum, mem);
                        mem[start][m] = Math.min(mem[start][m], Math.max(curr, t));
                    }
                }
            }
            return mem[start][m];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
