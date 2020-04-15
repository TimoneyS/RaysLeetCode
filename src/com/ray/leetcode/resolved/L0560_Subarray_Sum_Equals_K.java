package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K
 * -----------------------------------------------------------------------------
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example:
 *      Example 1
 *      Input:nums = [1,1,1], k = 2
 *      Output: 2
 *      Note:
 *      The length of the array is in range [1, 20,000].
 *      The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @since   2020-04-15 23:07:57
 */
public class L0560_Subarray_Sum_Equals_K {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < nums.length; i++)  nums[i] += nums[i-1];

            int rs = 0;
            map.put(0, 1);
            for (int n : nums) {
                rs += map.getOrDefault(n-k, 0);
                map.put(n, map.getOrDefault(n, 0)+1);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
