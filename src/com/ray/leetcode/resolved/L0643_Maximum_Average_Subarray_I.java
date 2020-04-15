package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Maximum Average Subarray I
 * -----------------------------------------------------------------------------
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example:
 *      Example 1
 *      Input: [1,12,-5,-6,50,3], k = 4
 *      Output: 12.75
 *      Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *      Note:
 *      	1 <= k <= n <= 30,000.
 *      	Elements of the given array will be in the range [-10,000, 10,000].
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * @since   2020-04-15 23:01:12
 */
public class L0643_Maximum_Average_Subarray_I {
    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            for (int i = 0; i < k; i++) sum += nums[i];
            int maxSum = sum;
            for (int i = k; i < nums.length; i++)
                maxSum = Math.max( (sum = sum + nums[i] - nums[i-k]), maxSum);
            return maxSum * 1.0 / k;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
